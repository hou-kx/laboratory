package com.quincy.laboratory.exam.redBook.q023;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        // 2 <= k <= n
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(upToNums(arr, k));
    }

    private static int upToNums(int[] arr, int k) {
        int res = 0;
        Set<Integer> kSet = new HashSet<>();
        Map<Integer, Integer> commonMap = new HashMap<>();

        for (int i = 0; i < arr.length - k; i++) {
            kSet.clear();
            commonMap.clear();
            for (int j = k + i; j < arr.length; j++) {
                for (int s = i; s < i + k; s++) {
                    commonMap.put(arr[s], commonMap.getOrDefault(arr[s], 0) + 1);
                    if (commonMap.get(arr[s]) >= k) kSet.add(arr[s]);
                }
                commonMap.put(arr[j], commonMap.getOrDefault(arr[j], 0) + 1);
                if (commonMap.get(arr[j]) >= k) kSet.add(arr[j]);
                res += kSet.size() > 0 ? 1 : 0;
            }
        }
        return res;
    }
}