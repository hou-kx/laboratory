package com.quincy.laboratory.exam.redBook.q001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int id = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i] += a[i][j];
            }
        }

        int ans = n;
        for (int i = 0; i < n; i++) {
            if (res[id - 1] > res[i]) {
                ans--;
            }
            if (res[id - 1] == res[i]) {
                if (id < i) {
                    ans--;
                }
            }
        }
        System.out.println(ans);
    }
}
