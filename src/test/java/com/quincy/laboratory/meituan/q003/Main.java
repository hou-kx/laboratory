package com.quincy.laboratory.meituan.q003;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        double[] maxRes = new double[n];
        double res = 0;
        for (int i = 0; i < n; i++) {
            res += a[i] * p[i] / 100.0;
            maxRes[i] += a[i] * (100 - p[i]) / 100.0;
        }
        Arrays.sort(maxRes);
        for (int i = 0; i < m; i++) {
            res += maxRes[n - i -1];
        }
        DecimalFormat format = new DecimalFormat("#.00");
        System.out.println(format.format(res));
    }
}
