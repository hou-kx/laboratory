package com.quincy.laboratory.exam.redBook.q002;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(findAllPlans(a, n, k));
    }

    public static int findAllPlans(int[] a, int n, int k) {
        int res = 0;
        if (n < 2) {
            return res;
        }
        Arrays.sort(a);
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 1; i < n; i++) {
            int j = (int) Math.sqrt(dp[i]) + 1;
            if (k <= (long) a[i] * a[i - j]) {
                dp[i + 1] = dp[i] * (dp[i] + 1);
            }
        }

        return dp[n];
    }
}
