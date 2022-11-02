package com.quincy.laboratory.exam.xiecehng.q001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            System.out.println(xToOdd(x));
        }
    }

    private static int xToOdd(int x) {
        int res = -1;
        if (x % 2 == 0) {
            return x;
        }
        // 只要将个位置为偶数即可
        char[] xArr = String.valueOf(x).toCharArray();
        for (int i = 0; i < xArr.length; i++){
            if ((xArr[i] - '0') % 2 == 0){
                char temp = xArr[xArr.length - 1];
                xArr[xArr.length - 1] = xArr[i];
                xArr[i] = temp;
                break;
            }
        }
        res = Integer.parseInt(String.valueOf(xArr));
        return res;
    }
}
