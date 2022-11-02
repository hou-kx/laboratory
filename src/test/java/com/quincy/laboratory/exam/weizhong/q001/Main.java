package com.quincy.laboratory.exam.weizhong.q001;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(sc.nextInt());
        }
        Arrays.sort(arr, (s1, s2) -> {
            if (s2.length() == s1.length()) {
                return s2.compareTo(s1);
            }
            return s2.length() - s1.length();
        });
        String[] str = Arrays.copyOfRange(arr, 0, 3);
        Arrays.sort(str, Comparator.reverseOrder());
        System.out.println(str[0] + str[1] + str[2]);
    }
}
