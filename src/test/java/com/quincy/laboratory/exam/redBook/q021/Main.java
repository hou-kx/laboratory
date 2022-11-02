package com.quincy.laboratory.exam.redBook.q021;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();
        int a4 = sc.nextInt();
        int x = sc.nextInt();
        int countA = 0, countB = 0, countC = 0, countD = 0;
        for (int i = 0; i < a1; i++) {
            int a = sc.nextInt();
            if (a > x) countA++;
        }
        for (int i = 0; i < a2; i++) {
            int b = sc.nextInt();
            if (b > x) countB++;
        }
        for (int i = 0; i < a3; i++) {
            int c = sc.nextInt();
            if (c > x) countC++;
        }
        for (int i = 0; i < a4; i++) {
            int d = sc.nextInt();
            if (d > x) countD++;
        }
        System.out.println(Math.min(Math.min(countA, countB), Math.min(countC, countD)));
    }
}
