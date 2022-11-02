package com.quincy.laboratory.exam.dp.q001;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return int整型
     */
    public static int longestValidParentheses(String s) {
        // write code here
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int j = i - dp[i - 1] - 1;
                if (j >= 0 && s.charAt(j) == '('){  // 找到上个左括号
                    dp[i] = (i - j + 1) + ((j - 1) >= 0 ? dp[j - 1] : 0);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }
}