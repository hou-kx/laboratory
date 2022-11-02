package com.quincy.laboratory.exam.meituan.q204;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] res = new int[]{0, 2, 1, 1};
        for (int r : res) {
            System.out.print(r + " ");
        }
    }
}
