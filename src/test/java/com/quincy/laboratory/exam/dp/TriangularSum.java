package com.quincy.laboratory.exam.dp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class TriangularSum {
    public int triangularSum1(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        dp[0] = nums;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1]) % 10;
            }
        }
        return dp[n - 1][0];
    }

    public static int[] triangularSum(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums;
        }
        while (--n > 1) {
            for (int i = 0; i < n; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        // return new int[]{nums[0], nums[1]};
        return Arrays.copyOfRange(nums, 0, 2);
    }

    @Test
    public void triangularSumTest() {
        int[] arr = {4, 5, 6, 7};
        int[] res = triangularSum(arr);
        System.out.println(Arrays.toString(res));
    }

}
