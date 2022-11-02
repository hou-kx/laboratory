package com.quincy.laboratory.exam.didi.q001;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        System.out.println(maxPeach(arr, n, k));
    }

    private static int maxPeach(long[] arr, int n, int k) {
        Arrays.sort(arr);
        int start = 0, end = 0;
        double curSum = 0;
        int res = 1;
        while (start <= end && end < n) {
            curSum += arr[end];
            double mean = curSum / (end - start + 1);
            if (arr[end] <= mean * k) {
                res = Math.max(res, end - start + 1);
                end++;
                continue;
            }
            while (arr[end] > mean * k && start < end) {
                curSum -= arr[start++];
                mean = curSum / (end - start + 1);
            }
            if (start > end) {
                end = start;
            }
        }
        return res;
    }
}
