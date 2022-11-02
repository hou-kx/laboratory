package com.quincy.laboratory.exam.redBook.q101;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] arrA = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
            list.add(arrA[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            list.add(arrA[i]);
        }
        if (m >= 0 && m <= 1) {
            System.out.println(list.get(k - 1));
        }
        if (m > 1) {
            System.out.println(list.get(k % list.size() - 1));
        }
    }
}
