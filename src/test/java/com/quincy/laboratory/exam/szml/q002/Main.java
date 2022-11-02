package com.quincy.laboratory.exam.szml.q002;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] strings = str.split(",");
        if (strings.length < 1) {
            System.out.println(0);
            return;
        }
        int n = Integer.parseInt(strings[0]);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String curStr = strSort(strings[i]);
            map.put(curStr, map.getOrDefault(curStr, 0) + 1);
        }
        System.out.println(map.size());
    }

    public static String strSort(String str) {
        int[] arr = new int[128];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < 128) {
            while (arr[index]-- > 0) {
                sb.append((char) index);
            }
            index++;
        }
        return sb.toString();
    }
}
