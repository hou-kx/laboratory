package com.quincy.laboratory.exam.weizhong.q002;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(toChange(a, b));
        }
    }

    private static int toChange(int a, int b) {
        // 保证 a > b
        if (a == b) return 0;
        if (a < b) return toChange(b, a);
        if ((a % b) % 2 != 0) {
            return -1;
        }

        int sum = 0, two = 0;
        while (a != b) {
            if (a % 2 == 0) {
                if (a / 2 >= b) {
                    a /= 2;
                    two++;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
        while (two >= 2) {
            if (two >= 3) {
                two -= 3;
            } else {
                two -= 2;
            }
            sum++;
        }
        return sum + two;
    }
}
