package com.quincy.laboratory.exam.tuhu.q002;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param g int整型二维数组
     * @return int整型
     */
    int[] colVisited;
    int maxRes;
    public int washCount(int[][] g) {
        // write code here
        colVisited = new int[g[0].length];
        maxRes = 0;
        return dfs(g, 0, 0, 0);
    }

    public int dfs(int[][] g, int row, int col, int ans) {
        if (row >= g.length || col >= g[0].length || g[row][col] == 0) return 0;
        maxRes = Math.max(maxRes, ans);
        for (int i = 0; i < g[0].length; i++) {
            if (g[row][i] == 0 || colVisited[i] == 1) continue;
            colVisited[i] = 1;
            ans++;

            dfs(g, row + 1, i, ans);
            ans--;
            colVisited[i] = 0;
        }
        return maxRes;
    }
}