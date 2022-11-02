package com.quincy.laboratory.exam.bilibili;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 尽可能分解为小一点的数，（正整数）两个数积 >= 两个数和
        int num = 2;
        int ans = 0;
        while (num < n / 2) {
            if (n % num == 0){
                n /= num;
                ans += num;
            }else {
                num++;
            }
        }
        System.out.println(ans + n);
    }
}