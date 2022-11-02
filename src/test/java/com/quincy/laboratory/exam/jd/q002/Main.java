package com.quincy.laboratory.exam.jd.q002;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n + 1];
        Set<Integer> repeatSet = new HashSet<>();
        List<Integer> repeatIndex = new ArrayList<>();
        List<Integer> replaceIndex = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            a[i] = sc.nextInt();

            if (i <= k) {
                // 找到前 K 个非法元素
                if (repeatSet.contains(a[i]) || a[i] > k) {
                    repeatIndex.add(i);
                }
            } else {
                // 找用于交换的元素
                if (a[i] <= k && !repeatSet.contains(a[i])) {
                    replaceIndex.add(i);
                }
            }
            repeatSet.add(a[i]);
        }
        if (repeatIndex.size() > replaceIndex.size()) {
            System.out.println(-1);
        } else {
            int res = 0;
            for (int i = repeatIndex.size() - 1; i >= 0; i--) {
                res += replaceIndex.get(i) - repeatIndex.get(i);
            }
            System.out.println(res);
        }
    }
}