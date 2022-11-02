package com.quincy.laboratory.exam.yuewen;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.engine.discovery.predicates.IsNestedTestClass;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        // write code here
        for (int i = m + n - 1; i >= 0; i--) {
            if (n == 0 && m > 0) {
                nums1[i] = nums1[m - 1];
                m--;
                continue;
            }
            if (m == 0 && n > 0) {
                nums1[i] = nums2[n - 1];
                n--;
                continue;
            }
            if (n > 0 && m > 0 && nums1[m - 1] < nums2[n - 1]) {
                nums1[i] = nums2[n - 1];
                n--;
                continue;
            }
            if (n > 0 && m > 0 && nums1[m - 1] >= nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            }
        }
        return nums1;
    }

    @Test
    public void test() {
//        System.out.println(Arrays.toString(merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3)));
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<int[]> arrList = new ArrayList<>(Arrays.asList(arr));
        int[][] test = arrList.toArray(new int[0][0]);
        System.out.println(Arrays.deepToString(test));

        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6};
        List<Integer> arrList1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        int[] test1 = arrList1.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(test1));
    }

    public int[][] merge(int[][] arr) {
        // write code here
        // 暴力循环
        List<int[]> res = new ArrayList<>();
        for (int[] a : arr) {
            boolean flag = true;
            for (int[] cur : res) {
                if (a[0] < cur[0] && cur[0] < a[1]) {
                    cur[0] = a[0];
                    if (cur[1] < a[1]) {
                        cur[1] = a[1];
                    }
                    flag = false;
                } else if (cur[0] < a[0] && a[0] < cur[1]) {
                    if (cur[1] < a[1]) {
                        cur[1] = a[1];
                    }
                    flag = false;
                }
            }
            if (flag) res.add(a);
        }
        return (int[][]) res.stream().toArray();
    }
}
