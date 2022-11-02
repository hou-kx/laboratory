package com.quincy.laboratory.exam.tuhu.q001;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 基金最大收益
     * @param funds int整型一维数组 基金价格
     * @return int整型
     */
    public int maxIncome (int[] funds) {
        // write code here
        int maxProfit = 0;
        for (int i =0; i < funds.length; i++){
            for (int j  = i + 1; j < funds.length; j++){
                int profit = funds[j] - funds[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}