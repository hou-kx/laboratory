package com.quincy.laboratory.exam.shunfeng.q001;

import org.apache.poi.hpsf.Decimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 1 ~ n， 相当于 第 i 次猜数字，都是 n - i 个元素的二分查找 （log2n）向下取整 + 1
        long res = 1;
        for (int i =2; i <= n ; i++){
            // log 换底公式
            res += (long)( Math.log(i) / Math.log(2)) + 1;
        }
        System.out.println(res);
    }
}
