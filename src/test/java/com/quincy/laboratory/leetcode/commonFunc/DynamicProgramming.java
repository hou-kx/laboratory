package com.quincy.laboratory.leetcode.commonFunc;

public class DynamicProgramming {

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
     *
     * @param n
     * @return
     */
    /**
     * 1 这里用的是递归的方式，很遗憾超时了
     */
    public int climbStairs01(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        return climbStairs01(n - 1) + climbStairs01(n - 2);
    }

    /**
     * 2 使用动态规划的方式， dp 数组保存的是每次的状态
     */
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 3 下面是动态规划-状态压缩, 可以看到上面每次 dp 只用到了两个状态
     * 当前状态的 n-1 和 n-2 状态故而只需要维护两个状态即可
     */
    public int climbStairs03(int n) {
        if (n < 3) {
            return n;
        }
        int n1 = 1, n2 = 2;
        for (int i = 3; i <= n; i++) {
            int last = n2;
            n2 += n1;
            n1 = last;
        }
        return n2;
    }

    /**
     * 一只青蛙一次可以
     *      跳上1级台阶
     *      也可以跳上2级
     *        ……
     *      它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法
     */
    /**
     * 1 这里用的是递归的方式
     */
    public int climbStairs10(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        return 2 * climbStairs01(n - 1);
    }

    /**
     * 2 使用动态规划的方式， dp 数组保存的是每次的状态
     */
    public int climbStairs11(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = 2 * dp[i - 1];
        }
        return dp[n];
    }

    /**
     * 3 下面是动态规划-状态压缩, 可以看到上面每次 dp 只用到了两个状态
     * 当前状态的 n-1 和 n-2 状态故而只需要维护两个状态即可
     */
    public int climbStairs12(int n) {
        if (n < 3) {
            return n;
        }
        int dp = 1;
        for (int i = 3; i <= n; i++) {
            dp *= 2;
        }
        return dp;
    }


    /**
     * 一只青蛙一次可以
     *      跳上1级台阶
     *      也可以跳上2级
     *        ……
     *      它也可以跳上 n 级。
     * 求该青蛙跳上一个 m 级的台阶总共有多少种跳法
     */
    /**
     * 1 这里用的是递归的方式
     */
    public int climbStairs20(int n, int m) {
        if (m < n) {
            return 2 * climbStairs20(n - 1, m) - climbStairs20(n - m - 1, m);
        }
        // 这个时候 m >= n 时
        if (n < 2) {
            return 1;
        } else {
            return 2 * climbStairs20(n - 1, m);
        }
    }

    /**
     * 2 使用动态规划的方式， dp 数组保存的是每次的状态
     */
    public int climbStairs21(int n, int m) {
        int[] dp = new int[m + 1];
        dp[1] = 1;
        for (int i = 2; i <= m; i++) {
            if (i < n) {
                dp[i] = 2 * dp[i - 1] - dp[n - i - 1];
            } else {
                dp[i] = 2 * dp[i - 1];
            }
        }
        return dp[m];
    }
}
