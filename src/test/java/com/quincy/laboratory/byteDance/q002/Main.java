package com.quincy.laboratory.byteDance.q002;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String match = sc.next();
        char[] chars = match.toCharArray();
        List<String> list = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            if (flag) {
                if (String.valueOf(chars[i]).equals("}"))
                {
                    flag = false;
                    continue;
                }
                continue;
            }
            if (String.valueOf(chars[i]).equals("{")) {
                list.add("*");
                flag = true;
                continue;
            }
            if (String.valueOf(chars[i]).equals("}")) {
                flag = false;
                continue;
            }
            list.add(String.valueOf(chars[i]));
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (String s : list) {
            stringBuilder.append(s);
        }

        List<String> title = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String next = sc.next();
            title.add(next);
        }
        for (String s : title) {
            boolean match1 = isMatch(s, stringBuilder.toString());
            if (match1) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }

    private static boolean isMatch(String s, String p) {
        boolean[][] value = new boolean[p.length() + 1][s.length() + 1];
        value[0][0] = true;
        for (int i = 1; i <= s.length(); i++){
            value[0][i] = false;
        }
        for (int i =1; i <= p.length(); i++){
            if(p.charAt(i - 1) == '*'){
                value[i][0] = value[i -1 ][0];
                for (int j = 1; j <= s.length(); j++){
                    value[i][j] = (value[i][j - 1] || value[i-1][j]);
                }
            }else {
                value[i][0] = false;
                for (int j = 1;j < s.length();j++){
                    value[i][j] = s.charAt(j - 1) == p.charAt(i - 1) && value[i - 1][j - 1];
                }
            }
        }
        return value[p.length()][s.length()];
    }
}
