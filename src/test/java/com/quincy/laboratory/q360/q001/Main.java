package com.quincy.laboratory.q360.q001;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            int[] scores = new int[n];
            for (int i = 0; i < n; i++) {
                scores[i] = sc.nextInt();
            }
            System.out.println(passNum(scores, n, p, q));
        }
    }

    private static int passNum(int[] scores, int n, int p, int q) {
        if (n < 1) {
            return 0;
        }
        int count = 0;
        Arrays.sort(scores);
        int pScore = 100; // 最高分的平时成绩为 100，然后依次往下轮
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                if ((p * pScore + q * scores[i]) / 100.0 < 60.0) {
                    break;
                }
                count++;
            } else if (i < n - 1 && scores[i] == scores[i + 1]) {
                count++;
            } else {
                if ((p * (--pScore) + q * scores[i]) / 100.0 < 60.0) {
                    break;
                }
                count++;
            }
        }
        return count;
    }
}