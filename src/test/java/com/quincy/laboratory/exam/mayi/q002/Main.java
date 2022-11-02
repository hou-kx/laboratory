package com.quincy.laboratory.exam.mayi.q002;

import java.util.*;

public class Main {
    static int[] power;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        power = new int[n + 1];
        Arrays.fill(power, 1);
        Map<Integer, List<Integer>> pathMap = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int from = Math.min(u, v);
            int to = Math.max(u, v);
            if (!pathMap.containsKey(from)) {
                List<Integer> list = new ArrayList<>();
                pathMap.put(from, list);
            }
            pathMap.get(from).add(to);
        }
        System.out.println(optionsTimes(pathMap));
    }

    private static int optionsTimes(Map<Integer, List<Integer>> pathMap) {
        int res = 0;
        Integer[] keys = pathMap.keySet().toArray(new Integer[0]);
        // Arrays.sort(keys);      //
        for (int key : keys) {
            // 若当前 子树根节点自增，则整个子树自增
            int gap = key - power[key];
            if (gap > 0) {
                // 所有子树自增
                dfs(pathMap, key, gap);
            }
        }
        for (int i = 1; i < power.length; i++) {
            res += i > power[i] ? i - power[i] : 0;
        }
        return res;
    }

    private static void dfs(Map<Integer, List<Integer>> pathMap, int root, int gap) {
        if (pathMap.containsKey(root)) {
            for (int v : pathMap.get(root)) {
                power[v] += v > power[v] ? gap : 0;
                if (pathMap.containsKey(v)) {
                    dfs(pathMap, v, gap);
                }
            }
        }
    }
}
