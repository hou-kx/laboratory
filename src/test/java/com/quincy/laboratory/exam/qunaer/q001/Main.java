package com.quincy.laboratory.exam.qunaer.q001;

public class Main {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 运动员可得到的最高分
     *
     * @param energy  int整型 运动员体力值
     * @param actions int整型二维数组 二维数组i为动作号 actions[i][0]为动作i+1消耗体力,actions[i][1]为动作i+1得分
     * @return int整型
     */
    public int maxScore(int energy, int[][] actions) {
        // write code here
        // 0 1 背包问题
        int n = actions.length;
        int[][] dp = new int[n + 1][energy + 1];
        for (int i = 1; i <= n; i++) {
            for (int e = 1; e <= energy; e++) {
                if (e - actions[i - 1][0] < 0) {
                    // 当前动作体力不够
                    dp[i][e] = dp[i - 1][e];
                } else {
                    dp[i][e] = Math.max(dp[i - 1][e], dp[i - 1][e - actions[i - 1][0]] + actions[i - 1][1]);
                }
            }
        }
        return dp[n][energy];
    }

    public static void main(String[] args) {
        int x = 1;
        System.out.println(Integer.MAX_VALUE);
    }
}
