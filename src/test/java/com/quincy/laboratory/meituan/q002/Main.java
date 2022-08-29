package com.quincy.laboratory.meituan.q002;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int xOne = sc.nextInt();
        int yOne = sc.nextInt();
        int xTwo = sc.nextInt();
        int yTwo = sc.nextInt();
        int xThree = sc.nextInt();
        int yThree = sc.nextInt();
        int bOne = sc.nextInt();
        int bTwo = sc.nextInt();
        int bThree = sc.nextInt();
        HashMap<Integer, Set<Integer>> res1 = findPoint(xOne, yOne, bOne, n);
        HashMap<Integer, Set<Integer>> res2 = findPoint(xTwo, yTwo, bTwo, n);
        HashMap<Integer, Set<Integer>> res3 = findPoint(xThree, yThree, bThree, n);

        int minRes = Integer.MAX_VALUE;
        for (Integer ig : res1.keySet()) {
            if (res2.containsKey(ig) && res3.containsKey(ig)) {
                Set<Integer> r3 = res3.get(ig);
                Set<Integer> r2 = res2.get(ig);
                Set<Integer> r1 = res1.get(ig);

                for (Integer ig1 : r1) {
                    if (r2.contains(ig1) && r3.contains(ig1)) {
                        int temp = ig * n + ig1;
                        minRes = Math.min(temp, minRes);
                    }
                }
            }
        }
        int x = minRes / n;
        int y = minRes % n;
        System.out.println(x + " " + y);
    }

    public static void addFunc(HashMap<Integer, Set<Integer>> map, int x, int y, int n) {
        if (x >= 1 && x <= n && y >= 1 && y <= n) {
            if (!map.containsKey(x)) {
                map.put(x, new HashSet<>());
            }
        }
        map.get(x).add(y);
    }

    private static HashMap<Integer, Set<Integer>> findPoint(int xP, int yP, int b, int n) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i <= b; i++) {
            int x = xP - i;
            int y = yP - (b - i);
            addFunc(map, x, y, n);
            y = yP + (b - i);
            addFunc(map, x, y, n);
            x = xP + i;
            addFunc(map, x, y, n);
            y = yP + (b - i);
            addFunc(map, x, y, n);
        }
        return map;
    }
}