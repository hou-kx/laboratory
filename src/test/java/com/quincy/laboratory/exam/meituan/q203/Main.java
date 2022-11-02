package com.quincy.laboratory.exam.meituan.q203;

import java.util.*;

public class Main {
    private static Map<Integer, List<Integer>> indexMap;
    private static long[] wArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n + 1];
        long[] w = new long[n + 1];
        // i 宝藏放在 pi 的房间中, 一个房间可能有多个宝藏
        Map<Integer, List<Integer>> roomIndexMap = new HashMap<>();
        int maxRoomIndex = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
            if (!roomIndexMap.containsKey(p[i])) {
                roomIndexMap.put(p[i], new ArrayList<>());
            }
            // 房间号  ： 多个宝藏序号列表
            roomIndexMap.get(p[i]).add(i);
            maxRoomIndex = Math.max(maxRoomIndex, p[i]);
        }
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }
        wArr = w;
        indexMap = roomIndexMap;
        System.out.println(maxTreasureValue(1, maxRoomIndex));
    }

    private static long maxTreasureValue(int room, int maxRoomIndex) {
        if (room > maxRoomIndex) {
            return 0;
        }
        long value = 0;
        if (indexMap.get(room) != null) {
            for (int i : indexMap.get(room)) {
                value += wArr[i];
            }
        }
        long leftVal = maxTreasureValue(room * 2, maxRoomIndex);
        long rightVal = maxTreasureValue(room * 2 + 1, maxRoomIndex);
        value += Math.max(leftVal, rightVal);
        return value;
    }
}


class Main1 {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            map.put(arr[i], in.nextInt());
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            int sum = 0;
            while (cur > 0) {
                sum += map.getOrDefault(cur, 0);
                cur /= 2;
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}