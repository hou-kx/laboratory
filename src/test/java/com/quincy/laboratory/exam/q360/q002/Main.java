package com.quincy.laboratory.exam.q360.q002;

import org.apache.commons.math3.analysis.function.Max;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    arr[row][col] = sc.nextInt();
                }
            }
            int res = Integer.MIN_VALUE;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    res = Math.max(res, maximalSquare(arr));
                }
            }
            System.out.println(res);
        }
    }

    // matrix[row][col]
    public static int maximalSquare(int[][] matrix) {
        // public int maximalSquare(int[][] matrix) {
        int row = matrix.length;
        if (row < 1) {
            return 0;
        }
        int col = matrix[0].length;

        int[][] dp = new int[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }

    // min(f[i][j−1], f[i−1][j], f[i−1][j−1])≥f[i][j]−1
}
