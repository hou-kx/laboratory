package com.quincy.laboratory.exam.byteDance.q013;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(magicStr(str));
    }

    private static int magicStr(String str) {
        int l = 0, r = 0;
        int[] mark = new int[26];
        for (int i = 0; i < str.length(); i++) {
            mark[str.charAt(i) - 'A']++;
        }
        int min = Integer.MAX_VALUE;
        int m = str.length() / 4;
        if (mark[0] == m && mark['S' - 'A'] == m && mark['F' - 'A'] == m && mark['D' - 'A'] == m) {
            return 0;
        }
        while (r < str.length()) {
            mark[str.charAt(r++) - 'A']--;
            while (mark[0] <= m && mark['S' - 'A'] <= m && mark['F' - 'A'] <= m && mark['D' - 'A'] <= m) {
                min = Math.min(min, r - l);
                mark[str.charAt(l++) - 'A']++;
            }
        }
        return min;
    }
}