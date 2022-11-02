package com.quincy.laboratory.exam.byteDance.q014;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n + 1];

        int left = 1, right = 1;
        int minVal = 0, maxVal = 0;
        int maxLen = 1;
        // 维护一个 left - right 之间最大、小值
        for (int i = 1; i < n + 1; i++, right++) {
            arr[i] = sc.nextInt();
            if (i == 1) {
                minVal = maxVal = arr[i];
            }
            maxVal = Math.max(maxVal, arr[i]);
            minVal = Math.min(minVal, arr[i]);
            if (maxVal - minVal <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            } else {
                // 这个时候移动 left 直到 left ~ right 之间的最大最小值满足条件为止
                while (left <= right && maxVal - minVal > k) {
                    maxVal = Math.max(maxVal, arr[left]);
                    minVal = Math.min(minVal, arr[left]);
                    left++;
                }
            }
        }

        int from = 1, to = 1;
        List<int[]> res = new ArrayList<>();
        while (to <= n) {
            int[] curArr = new int[2];
            curArr[0] = from;

            int curMin = arr[from], curMax = arr[from];
            int curLen = 1;
            while (to <= n && from <= to && curLen++ <= maxLen && curMax - curMin <= k) {
                curMax = Math.max(curMax, arr[to]);
                curMin = Math.min(curMin, arr[to]);
                curArr[1] = to;
                // if ( to == n) break;
                to++;
            }
            from = to;
            res.add(curArr);
        }
        System.out.println(maxLen + " " + res.size());
        for (int[] r : res) {
            System.out.println(r[0] + " " + r[1]);
        }
    }
}
