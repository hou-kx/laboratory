package com.quincy.laboratory.exam.redBook.q102;

import org.apache.commons.math3.analysis.function.Max;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] nums = new Integer[n];
        // 每次数加 1 或者 减 1
        // 必须保证最终数组内所有的绝对值 1,7  只能有一个7, 负数出现的次数必须为偶数。
        int count = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (nums[i] < 0) {
                count++;
            }
        }
        if (n == 1) {
            // 只有一个直接变为 7
            System.out.println(Math.abs(7 - nums[0]));
            return;
        }
        // 绝对值进行排序
        Arrays.sort(nums, (o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                // 若绝对值相等，按负、正排序
                return Math.min(o1, o2);
            }
            return Math.abs(o1) - Math.abs(o2);
        });
        int times = 0;
        int startIndex = 0;
        int num7 = Math.abs(7 - nums[nums.length - 1]);
        int num_7 = Math.abs(-7 - nums[nums.length - 1]);
        // 首尾处理
        if (count % 2 == 1) {
            // 需要变号
            int num1 = Math.abs(1 - nums[0]);
            int num_1 = Math.abs(-1 - nums[0]);
            if (Math.abs(1 - Math.abs(nums[0])) < Math.abs(7 - Math.abs(nums[nums.length - 1]))) {
                // 首部变号代价小则最小值转为 1 或者 -1; >= 0 变 -1
                times += nums[startIndex] >= 0 ? num_1 : num1;
                times += nums[nums.length - 1] >= 0 ? num7 : num_7;
                startIndex = 1;
            }else {
                // 若末尾的代价小则给末尾换符号
                times += nums[nums.length - 1] >= 0 ? num_7 : num7;
            }
        } else {
            // 不需要变号
            times += nums[nums.length - 1] >= 0 ? num7 : num_7;
        }
        for (int i = startIndex; i < n - 1; i++) {
            times += nums[i] >= 0 ? Math.abs(1 - nums[i]) : Math.abs(-1 - nums[i]);
        }
        System.out.println(times);
    }
}
