package com.quincy.laboratory.exam.jd.q001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a <= b + 1) {
            while (b > 0) {
                if (a > 0) {
                    a--;
                    System.out.print(1 + " ");
                }
                b--;
                System.out.print(2 + " ");
            }
            if (a > 0) {
                System.out.print(1);
            }
        } else {
            System.out.println(-1);
        }
    }
}
