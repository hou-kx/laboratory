package com.quincy.laboratory.exam.guanglianda.q002;

import java.util.*;

public class Main {

    public static void main(String[] args) {
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
        Arrays.sort(res, (a,b) -> a[0] - b[0]);
        for (int[] i : res){
            System.out.println(Arrays.toString(i));
        }
        System.out.println("\n=================================\n");

        Arrays.sort(res1, (a,b) -> a[1] - b[1]);
        for (int[] i : res1){
            System.out.println(Arrays.toString(i));
        }
        System.out.println("\n=================================\n");

        Arrays.sort(res2, (a,b) -> a[2] - b[2]);
        for (int[] i : res2){
            System.out.println(Arrays.toString(i));
        }
        System.out.println("\n=================================\n");
    }
}
