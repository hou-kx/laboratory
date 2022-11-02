package com.quincy.laboratory.exam.meituan.q202;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0, count = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
            if (a[i] == 0) {
                count++;
            }
        }
        if (sum == 0 && count == 0) {
            // 和为 0 但不存在 0 参数，仅需要更改一次
            System.out.println(1);
        } else if (count != 0 && sum + count == 0) {
            // 存在 0 参数，且 0 参个数与参数和互为相反数，则正好需要多 1 次的变动
            System.out.println(++count);
        } else {
            // 其他情况只需要把 0 值改了即可
            System.out.println(count);
        }
    }
}
