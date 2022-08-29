package com.quincy.laboratory.weilai.q002;

import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            calculate(n, m);
        }
    }
    public static void calculate(int n, int m) {
        int count = 0;
        int lastNum = 0;
        if (m < n) {
            // 处理为 n < m
            count += n / m;
            n %= m;
        }
        if (m == n) {
            count += 1;
            lastNum = n;
        }
        if (m > n) {
            if (0.7 * m <= n) {
                count += 1;
                lastNum = (int) (0.7 * m);  // m 为 10 的整数倍
                n -= lastNum;
            }
            if (0.3 * m <= n) {
                count += n / (int) (0.3 * m);
                lastNum = (int) (0.3 * m);  // m 为 10 的整数倍
                n -= lastNum * n / (int) (0.3 * m);
            }
            if (n > 0) {
                count += 1;
                lastNum = n;
                n -= n; //多余
            }
        }
        System.out.println(count + " " + lastNum);
    }
}
