package com.quincy.laboratory.exam.byteDance.q012;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int res = 0, index = 0;
        while (index < str.length() - res && index < str.length() - 3) {
            int j = index + 1;
            while (j < str.length()) {
                if (str.charAt(j) == str.charAt(j - 1)) {
                    break;
                }
                j++;
            }
            int temp = j - index;
            res = temp > 2 && temp > res ? temp : res;
            index = j;
        }
        System.out.println(res);
    }
}
