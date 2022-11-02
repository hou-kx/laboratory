package com.quincy.laboratory.exam.gaotu.q001;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            if (!set.contains(a.charAt(i) - '0')) {
                sb.append(a.charAt(i));
                set.add(a.charAt(i) - '0');
            }
        }
        System.out.println(Long.parseLong(sb.toString()));
    }
}
