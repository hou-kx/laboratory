package com.quincy.laboratory.exam.baidu.q002;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] monster = new int[n];
        for (int i = 0; i < n; i++) {
            monster[i] = sc.nextInt();
        }
        long res = 0;
        int left = 0, right = left + 2;
        while (right < n) {
            boolean flag = true;
            while (flag) {
                if (monster[left] < 1 || monster[left + 1] < 2 || monster[left + 2] < 3) flag = false;
                if (flag) {
                    for (int i = 0; i < 3; i++) {
                        monster[left + i] -= (i + 1);
                    }
                    res += 5;
                }
            }
            left++;
            right++;
        }
        for (int m : monster) res += m;
        System.out.println(res);
    }
}
