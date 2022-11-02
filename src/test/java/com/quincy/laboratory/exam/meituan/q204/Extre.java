package com.quincy.laboratory.exam.meituan.q204;

import java.util.Scanner;

public class Extre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArr = sc.next().toCharArray();
        int n = charArr.length;
        int[] preSum = new int[n + 1];
        int count = 0, lastIndex = 0;
        for (int i = 0; i < n; i++) {
            int cur = charArr[i] - '0';
            preSum[i + 1] = preSum[i] + cur;
            for (int j = i; j> lastIndex;j--){
                if ((preSum[i + 1] - preSum[j]) % 7 == 0) {
                    count++;
                    lastIndex = j;
                }
            }
        }
        System.out.println(count);
    }
}
