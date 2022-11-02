package com.quincy.laboratory.exam.byteDance.q001;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 双休在家的凯凯真的是太无聊了，他准备和他家的猫玩一个游戏。
 * 凯凯随手写下一串01数列，定义这串数列的子串和为所有长度为2的子串的和。比如数列=010001，有如下长度为2的子串：
 * 01 （前导0， =1）
 * 10
 * 00 （前导0，=0）
 * 00 （前导0，=0）
 * 01 （前导0，=1）
 * 所以和为1+10+0+0+1 = 12
 * <p>
 * 如果要只是算子串和的话，那对喵喵来说实在是太简单了，所以凯凯准备加大难度。
 * 喵喵有k次机会可以交换数列里的相邻两个数（可以不用完这k次机会），使得交换完之后子串和最小。
 * 这下喵喵不会做了，你可以帮帮它么？ 输入为先输入一个t，代表t组。然后分别是n、k，字符串。
 * input:
 3
 4 0
 1010
 7 5
 0010100
 5 2
 00110
 * <p>
 * output:
 * 21
 * 22
 * 12
 * <p>
 * 分析字符串中每一个1，只有3种情况：
 * <p>
 * 出现在字符串首部，贡献为10
 * 出现在字符串中央，贡献为11
 * 出现在字符串末尾，贡献为01
 * 那么只需要考虑能不能把1换到头尾就好了。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] res = new int[t];
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String str = sc.next();
            if (str.length() == n && n > 1) {
                res[i] = minSumByCount1(str, n, k);
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println(res[i]);
        }
    }

    public static int minSumByCount1(String str, int n, int k) {

        String[] strArr = str.split("");

        int count1 = (int) Arrays.stream(strArr).filter(s -> s.equals("1")).count();

        for (char c : str.toCharArray()) {
            if (c == '1') {
                count1++;
            }
        }
        int res = count1 * 11;

        // 1 能否放末尾
        if (str.charAt(n - 1) == '1') {
            res -= 10;
        } else if (k > 0) {
            int i = n - 2;
            while (i > 0 && n - 1 - i <= k) {
                if (str.charAt(i) == '1') {
                    k -= n - 1 - i;
                    res -= 10;
                    break;
                }
                i--;
            }
        }

        // 1 能否放首位
        if (str.charAt(0) == '1') {
            res -= 1;
        } else if (k > 0) {
            int i = 1;
            while (i < n - 1 && i <= k) {
                if (str.charAt(i) == '1') {
                    res -= 1;
                    break;
                }
                i++;
            }
        }
        return res;
    }
}