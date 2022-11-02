package com.quincy.laboratory.exam.meituan.q001;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            sc.nextLine();
            String aStr = sc.nextLine();
            String bStr = sc.nextLine();

            if(aStr.length() == bStr.length() && aStr.length() == n) {
                System.out.println(merge(aStr,bStr,n));
            }else {
                System.out.println("-1");
            }
        }
    }

    private static String merge(String a, String b, int n) {
        StringBuilder res = new StringBuilder();
        for (int i =0;i< n;i++){
            res.append(a.charAt(i)).append(b.charAt(i));
        }
        return res.toString();
    }
}
