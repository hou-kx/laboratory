package com.quincy.laboratory.exam.gaotu.q003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String num2 = sc.next();
        System.out.println(multiply(num1, num2));
    }

    private static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        // 两个分别为m、n位的数相乘，积的位数最多为 m+n， 最少为 m+n-1。
        int[] sumArr = new int[m + n];
        // 先按照竖式计算流程进行，这个过程不进行进位操作
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                sumArr[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        // 将每个元素化为个位，即向进位操作
        for (int i = m + n - 1; i > 0; i--) {
            sumArr[i - 1] += sumArr[i] / 10;
            sumArr[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        // 舍去最高位 0
        int starIndex = sumArr[0] == 0 ? 1 : 0;
        for (int i = starIndex; i < m + n; i++) {
            sb.append(sumArr[i]);
        }
        return sb.toString();
    }
}