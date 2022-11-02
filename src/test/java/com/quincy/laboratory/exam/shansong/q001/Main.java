//package com.quincy.laboratory.exam.shansong.q001;
//
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] arrays = sc.next().split(";");
//        if (arrays.length != 2) System.out.println("[]");
//
//        String[] str1 = arrays[0].substring(1, arrays[0].length() - 1).split(",");
//        String[] str2 = arrays[1].substring(1, arrays[1].length() - 1).split(",");
//        int[] nums1 = new int[str1.length];
//        for (int i = 0; i < str1.length; i++) {
//            nums1[i] = Integer.parseInt(str1[i]);
//        }
//        int[] nums2 = new int[str1.length];
//        for (int i = 0; i < str2.length; i++) {
//            nums2[i] = Integer.parseInt(str2[i]);
//        }
//        System.out.println(Arrays.toString(disArrays(nums1, nums2)));
//    }
//
////    private static int[] disArrays(int[] nums1, int[] nums2) {
////        List<Integer> list = new ArrayList<>();
////        int maxLen = Math.max(nums1.length, nums2.length);
////        int index = 0;
////        int a = 0, b = 0;
////        while(a < maxLen && b < maxLen){
////
////        }
////    }
//}
