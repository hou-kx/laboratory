package com.quincy.laboratory.exam.gaotu.q002;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] edge = new int[3];
        for (int i = 0; i < 3; i++) {
            edge[i] = sc.nextInt();
        }
        // 任意两边之和大于第三边
        // 只要最小的两个边的和大于最大的边长满足条件
        Arrays.sort(edge);
        if (edge[0] + edge[1] > edge[2]) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}