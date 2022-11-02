package com.quincy.laboratory.exam.redBook.q022;

import java.util.Scanner;

public class Main {
    // static int
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] high = new int[n];
        for (int i = 0; i < n; i++) {
            high[i] = sc.nextInt();
        }
        System.out.println(costs(high, k));
    }

    private static int costs(int[] high, int k) {
        int len = high.length;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            int tmp = Integer.MAX_VALUE;
            for (int j = i - k; j < i; j++) {
                if (j < 0) continue;
                tmp = Math.min(tmp, Math.max(high[i] - high[j], 0) + dp[j]);
            }
            dp[i] = tmp;
        }
        return dp[len - 1];
    }
}