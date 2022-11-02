package com.quincy.laboratory.exam;

public class Mian {
    public static void main(String[] args) {
        System.out.println(sum("1000000000000000","2000000000000000"));
    }
    public static String sum(String numA, String numB) {
        // write code here
        int lenA = numA.length(), lenB = numB.length();
        int len = Math.max(lenA, lenB);
        int[] res = new int[len + 1];
        for (int i = len; i > 0; i--) {
            int a = lenA > 0 ? numA.charAt(--lenA) - '0' : 0;
            int b = lenB > 0 ? numB.charAt(--lenB) - '0' : 0;
            res[i] = a + b;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = len; i > 0; i--) {
            if (res[i] > 9) {
                res[i - 1] += res[i] / 10;
                res[i] %= 10;
            }
            sb.append(res[i]);
        }
        if (res[0] > 0) sb.append(res[0]);
        return sb.reverse().toString();
    }
}
