package com.quincy.laboratory.exam.guanglianda.q001;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        System.out.println(numOfChanged(n , s, p));

    }

    private static int numOfChanged(int n, int[] s, int[] p) {
        int res = 0;
        int begin = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(s[i])){
                continue;
            }
            set.add(s[i]);
            while(begin < n){
                if (p[begin] != s[i]){
                    res++;
                    set.add(p[begin]);
                }else {
                    begin++;
                    break;
                }
                begin++;
            }
        }
        return res;
    }
}
