package com.quincy.laboratory.exam.meituan.q012;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrays = new int[n];
        for (int i = 0; i < n; i++) {
            arrays[i] = sc.nextInt();
        }
        int[] res = new int[n];
        int[] copyArrays = arrays.clone();

        Arrays.sort(copyArrays);

        for (int i = 0; i < n; i++) {
            int val = arrays[i];
            for (int j = 0; j < n; j++) {
                if (copyArrays[j] == j) {
                    if (j == val) {
                        res[i] = j;
                        break;
                    }
                } else {
                    res[i] = j;
                    break;
                }
            }
        }
        for (int r : res) {
            System.out.print(r + " ");
        }
    }
}
