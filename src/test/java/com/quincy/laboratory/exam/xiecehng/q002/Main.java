package com.quincy.laboratory.exam.xiecehng.q002;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int min = Math.min(a, Math.min(b, c));  // 最小值
            int max = 2 * min;
            b -= min;
            if (b > 0) {
                max += b - 1;
            }
            System.out.println(max);
        }
    }
}
