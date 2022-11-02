package com.quincy.anonymous;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class arraysSort {
    public static void main(String[] args) {
        //anonymousTest();

        // newComparatorTest();
        find3();
    }

    public static void anonymousTest() {
        int[][] res = new int[][]{
                {3, 18, 33},
                {6, 16, 11},
                {9, 12, 22}
        };
        int[][] res1 = new int[][]{
                {3, 18, 33},
                {6, 16, 11},
                {9, 12, 22}
        };
        int[][] res2 = new int[][]{
                {3, 18, 33},
                {6, 16, 11},
                {9, 12, 22}
        };
        Arrays.sort(res, (a, b) -> a[0] - b[0]);
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("\n=================================\n");

        Arrays.sort(res1, (a, b) -> a[1] - b[1]);
        for (int[] i : res1) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("\n=================================\n");

        Arrays.sort(res2, (a, b) -> a[2] - b[2]);
        for (int[] i : res2) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("\n=================================\n");
    }

    public static void newComparatorTest() {
        int[][] res = new int[][]{
                {3, 18, 33},
                {3, 16, 11},
                {9, 12, 22}
        };
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("\n=================================\n");

        Arrays.sort(res, (a, b) -> b[0] - a[0]);
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("\n=================================\n");

        // Arrays.sort(res,new Comparator<int[]>(){
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {   // 若一维元素相等
                    return a[1] - b[1]; // 则按照二维元素升序返回
                } else {
                    return b[0] - a[0];  // 否则，按照一维元素降序返回，故得到最终输出结果！
                }
            }
        });
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }
    }

    // lambda
    public static void find3() {
        int[][] res = new int[][]{
                {3, 18, 33},
                {3, 16, 11},
                {9, 12, 22}
        };

        // list<int[]>  lambda python java c++
        res = Arrays.stream(res).filter(a -> a[0] == 3).collect(Collectors.toList()).toArray(new int[0][0]);

        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }

    }
}
