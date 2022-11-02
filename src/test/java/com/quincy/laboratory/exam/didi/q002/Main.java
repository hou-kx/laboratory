package com.quincy.laboratory.exam.didi.q002;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] lArr = new int[n];
        int[] rArr = new int[n];
        int[] tArr = new int[n];
        for (int i = 0; i < n; i++) {
            lArr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            rArr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            tArr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(findBeautyNum(lArr[i], rArr[i], tArr[i]) + " ");
        }
    }

    private static int findBeautyNum(int l, int r, int t) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            char[] nums = String.valueOf(i).toCharArray();
            int xorRes = nums[0] - '0';
            for (int j = 1; j < nums.length; j++) {
                xorRes ^= nums[j] - '0';
            }
            if (xorRes == t) count++;
        }
        return count;
    }
}
