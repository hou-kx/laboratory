package com.quincy.laboratory.exam.Bankzhongxin.q002;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String strAEIOU = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (strAEIOU.indexOf(c) < 0) {
                sb.append((char) (c + (c >= 'a' ? -32 : 0)));
            } else {
                sb.append((char) (c + (c >= 'a' ? 0 : 32)));
            }
        }
        System.out.println(sb);
    }
}
