package com.quincy.laboratory.exam.meituan.q013;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fatherNode = new int[n];
        for (int i = 1; i < n; i++) {
            fatherNode[i] = sc.nextInt();
        }
        fatherNode[0] = 0;
        String values = sc.next();
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            // 找到当前节点
            set.add(values.charAt(i));
            map.put(i, set);
            if (i == 0) {
                // 根节点
                continue;
            }
            // 每找到一个节点，向上级汇报, fatherNode[i] 是 i 节点的父节点
            int fatherIndex = fatherNode[i];      // 实际父亲节点是  fatherNode[i] - 1 => fatherIndex - 1
            int cur = i;
            while (fatherIndex != 0){
                map.get(fatherIndex - 1).addAll(map.get(cur)); // 添加当前节点内容到父节点
                cur = fatherIndex - 1;
                fatherIndex = fatherNode[cur];
            }
        }
        for (int i = 0; i < n; i++){
            System.out.print(map.get(i).size() + " ");
        }
    }
}