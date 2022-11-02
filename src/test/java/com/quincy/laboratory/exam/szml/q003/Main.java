package com.quincy.laboratory.exam.szml.q003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int res = 0;
        int len = str1.length();
        for (int i = 0; i <= len; i++) {
            // 假若插入str2后，不等直接下个
            if (str1.charAt(i) != str1.charAt(len + str2.length() - i - 1)) {
                continue;
            }

            StringBuilder sb = new StringBuilder(str1);
            sb.insert(i, str2);
            if (isRight(sb.toString())) res++;
        }
        System.out.println(res);
    }

    public static boolean isRight(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}