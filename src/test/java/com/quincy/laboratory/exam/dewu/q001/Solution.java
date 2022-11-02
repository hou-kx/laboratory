package com.quincy.laboratory.exam.dewu.q001;

import org.apache.ibatis.annotations.Mapper;

import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 获取最大利润
     *
     * @param prices int整型一维数组 股票价格列表
     * @return int整型
     */
    public int getProfit(int[] prices) {
        // write code here
        // 使用动态规划
        int minPrice = Integer.MAX_VALUE;
        int dp = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                minPrice = prices[0];
            } else {
                minPrice = Math.min(minPrice, prices[i]);
                dp = Math.max(dp, prices[i] - minPrice);
            }
        }
        return dp;
    }

    public int[] findOrder(int[][] prerequisites, int n) {
        // write code here
        if (n <= 0) {
            return new int[0];
        }
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }

        int[] inDegree = new int[n];
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[n];
        int count = 0;
        while (!queue.isEmpty()) {
            Integer head = queue.poll();
            res[count++] = head;

            Set<Integer> successors = adj.get(head);
            for (Integer next : successors) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (count == n) {
            return res;
        }
        return new int[0];
    }
}
