package com.quincy.laboratory.exam.Bankzhongxin.q001;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] counts = new int[26];
        Arrays.fill(counts, 0);
        for (char c : str.toCharArray()) {
            counts[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (counts[i] >= 2) sb.append((char) ('a' + i));
        }
        System.out.println(sb);
    }
}

class LazySingleton {
    private static volatile LazySingleton instance = null;    //保证 instance 在所有线程中同步

    private LazySingleton() {
    }    //private 避免类在外部被实例化

    public static synchronized LazySingleton getInstance() {
        //getInstance 方法前加同步
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }


}


