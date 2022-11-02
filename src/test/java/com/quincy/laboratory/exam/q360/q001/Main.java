package com.quincy.laboratory.exam.q360.q001;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            Integer[] copyArr = Arrays.copyOfRange(arr, 0, x);
            Arrays.sort(copyArr, (a, b) -> {
                if (t == 0) {
                    return a - b;
                } else {
                    return b - a;
                }
            });
            if (x >= 0) System.arraycopy(copyArr, 0, arr, 0, x);
        }
        for (Integer a : arr) {
            System.out.print(a + " ");
        }
    }
}
