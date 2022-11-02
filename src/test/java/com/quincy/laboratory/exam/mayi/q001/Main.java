package com.quincy.laboratory.exam.mayi.q001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x == 1) {
            System.out.println("a");
        } else {
            StringBuilder sb = new StringBuilder();
            if (x % 2 == 1) {
                x--;
                sb.append("a");
            }
            while (x > 0) {
                int a = 1;
                int num = 2;
                while (num <= x) {
                    a++;
                    num += 2;
                }
                char ch = (char) ((a - 1) + 'a');
                sb.append(ch);
                x -= (num / 2);
            }
            System.out.println(sb);
        }

    }
}
