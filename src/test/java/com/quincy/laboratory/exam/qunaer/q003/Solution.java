package com.quincy.laboratory.exam.qunaer.q003;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 翻牌
     *
     * @param inHand string字符串 一组以单空格间隔的手牌(例如：SA HK H9 D8 C5 S5 H4)
     * @return string字符串
     */
    public static String showDown(String inHand) {
        // write code here
        Map<Character, Integer> colorMap = new HashMap<>();
        colorMap.put('S', 0);
        colorMap.put('H', 1);
        colorMap.put('C', 2);
        colorMap.put('D', 3);
        Map<Character, Integer> exMap = new HashMap<>();
        // 0 ~ 12
        exMap.put('J', 10);
        exMap.put('Q', 11);
        exMap.put('K', 12);
        exMap.put('A', 0);
        String[] s = inHand.split(" ");
        int[][] cd_count = new int[4][13];
        int[] c_count = new int[4];
        int[] d_count = new int[13];
        for (int i = 0; i < s.length; i++) {
            int c = colorMap.get(s[i].charAt(0));
            String dian = s[i].substring(1);
            Integer d = exMap.get(dian.charAt(0));
            if (d == null) {
                d = Integer.parseInt(dian) - 1;
            }
            cd_count[c][d]++;
            c_count[c]++;
            d_count[d]++;
        }
        for (int i = 0; i < 4; i++) {
            int d = 9;
            for (; d < 13; d++) {
                if (cd_count[i][d] == 0) {
                    break;
                }
            }
            if (d == 13 && cd_count[i][0] > 0) {
                return "HuangJiaTongHuaShun";
            }
        }
        for (int i = 0; i < 4; i++) {
            int count = 0;
            for (int j = 0; j < 13; j++) {
                if (cd_count[i][j] > 0) {
                    count++;
                } else {
                    if ((count >= 5)) {
                        return "TongHuaShun";
                    } else {
                        count = 0;
                    }
                }
            }
        }

        Map<Integer, Integer> cMap = new HashMap<>();
        for (int i = 0; i < 13; i++) {
            cMap.put(d_count[i], cMap.getOrDefault(d_count[i], 0) + 1);
        }

        if (cMap.containsKey(4)) {
            return "SiTiao";
        }

        if (cMap.containsKey(3) && cMap.containsKey(2)) {
            return "HuLu";
        }

        for (int i = 0; i < 4; i++) {
            if (c_count[i] >= 5) {
                return "TongHua";
            }
        }
        int count = 0;
        for (int i = 0; i < 13; i++) {
            if (d_count[i] > 0) {
                count++;
            } else {
                if (count >= 5) {
                    return "ShunZi";
                } else {
                    count = 0;
                }
            }
        }
        if (cMap.containsKey(3)){
            return "SanTiao";
        }
        if (cMap.get(2) >= 2){
            return "LiangDui";
        }
        if(cMap.get(2) == 1){
            return "YiDui";
        }
        return "GaoPai";
    }

    public static void main(String[] args) {
        System.out.println(showDown("SA SK SQ SJ S10 H10 C9"));
    }
}
