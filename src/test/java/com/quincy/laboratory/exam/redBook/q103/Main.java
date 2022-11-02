package com.quincy.laboratory.exam.redBook.q103;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

/**
 * 题目描述：
 * 小明的旅途中需要经过一个国家。这个国家有n个城市，编号为1到n。
 * 小明会从1号城市进入，目标是从n号城市出去（即要从1号城市到达n号城市）。有m条双向道路连接这n个城市，每条道路的长度都是1，并且都有一个过路费（是[1,100000]之间的整数）。
 * 当小明在一号城市时，他可以预先花费X的费用办一张特权卡，他可以获得所有过路费不超过X的道路的通行权（而其他道路无法通过）。
 * 小明一天最多只能走k长度的路，他想知道如果他想在一天之内从1号城市走到n号城市，他最少需要花费多少来办特权卡，即求X的最小值？
 * <p>
 * 输入描述
 * 第一行是3个整数n，m，k，分别表示城市数，道路数和小明一天最多能走的长度。
 * <p>
 * 第二行m个整数，分别为u1, u2, …, um，分别表示第i条道路的一个端点。
 * <p>
 * 第三行m个整数，分别为v1, v2, …, vm，分别表示第i条道路的另一个端点。
 * <p>
 * 第四行m个整数，分别为w1, w2, …, wm，分别表示第i条道路的过路费。
 * <p>
 * 数字间两两有空格隔开。数据保证一定存在解。
 * <p>
 * 输出描述
 * 一行一个整数，表示X的最小值。
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        // 道路起点、终点城市
        int[] start = new int[m];
        int[] end = new int[m];
        int[] cost = new int[m];
        for (int i = 0; i < m; i++) {
            start[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            end[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            cost[i] = sc.nextInt();
        }

        // 贪心走一波,似乎不太行
        int res = Integer.MAX_VALUE;
        for (int c : cost) {
            res = Math.min(c, res);
        }
        System.out.println(res);
    }

    public int minPathSum(int[][] grid) {
        // 二维动态规划
        // dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]  维护边界
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (r == 0 && c == 0) {
                    dp[r][c] = grid[r][c];
                } else if (r == 0) {
                    dp[r][c] = dp[r][c - 1] + grid[r][c];
                } else if (c == 0) {
                    dp[r][c] = dp[r - 1][c] + grid[r][c];
                } else {
                    dp[r][c] = Math.min(dp[r - 1][c], dp[r][c - 1]) + grid[r][c];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    char[][] board;
    String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        int row = board.length, col = board[0].length, wLen = word.length();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 任一节点作为起点，查询是否可以找到目标 word 单词路径
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, int w) {
        // 越界 or 路径匹配失败
        if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length ||
                w >= word.length() || board[row][col] != word.charAt(w)) {
            return false;
        }
        // 匹配成功结束
        if (w == word.length() - 1) {
            return true;
        }
        // 上下左右遍历，防止多次遍历该节点； ==> 节点值匹配成功，则置为空， 访问结束在修复
        board[row][col] = ' ';
        boolean res = dfs(row, col + 1, w + 1) ||
                dfs(row - 1, col, w + 1) ||
                dfs(row, col - 1, w + 1) ||
                dfs(row + 1, col, w + 1);
        // 修复节点值
        board[row][col] = word.charAt(w);
        return res;
    }
}
