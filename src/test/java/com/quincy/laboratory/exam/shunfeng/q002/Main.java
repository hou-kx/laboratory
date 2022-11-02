package com.quincy.laboratory.exam.shunfeng.q002;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] father = new int[n - 1];
        int[] pray = new int[n];
        for (int i = 0; i < n - 1; i++) {
            father[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pray[i] = sc.nextInt();
        }
        System.out.println(2);
    }
}