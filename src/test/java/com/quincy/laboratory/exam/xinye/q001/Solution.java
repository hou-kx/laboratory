package com.quincy.laboratory.exam.xinye.q001;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strArr = new String[n];
        for (int i = 0;i<n;i++){
            strArr[i] = sc.nextLine();
        }
        SolutionTest st = new SolutionTest();
        System.out.println(st.dateArraysSum(strArr));
    }
}

class SolutionTest {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 日期字符串数组一年中的几天求和
     *
     * @param dates string字符串一维数组 日期字符串数组
     * @return int整型
     */
    String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    Map<String, Integer> monthsMap;

    public SolutionTest() {
        Map<String, Integer> monthsMapTmp = new HashMap<>();
        for (int i = 0; i < monthNames.length; i++) {
            monthsMapTmp.put(monthNames[i], i);
        }
        monthsMap = monthsMapTmp;
    }

    public int dateArraysSum(String[] dates) {
        // write code here
        int total = 0;
        for (String date : dates) {
            total += dateToDays(date);
        }
        return total;
    }

    private int dateToDays(String date) {
        String[] dataStr = date.split(" ");
        if (dataStr.length < 3) return 0;
        String[] ymd = new String[3];
        int index = 0;
        for (int i = 0; i < dataStr.length; i++) {
            if (dataStr[i] == null || Objects.equals(dataStr[i], "") || Objects.equals(dataStr[i], " ")) {
                continue;
            }
            if (index == 3) break;
            ymd[index++] = dataStr[i];
        }

        int year = Integer.parseInt(ymd[2]);
        int month = monthsMap.get(ymd[1]);
        int day = ymd[0].charAt(0) - '0';
        int day2 = ymd[0].charAt(1) - '0';
        if (day2 >= 0 && day2 < 10) {
            day = day * 10 + day2;
        }
        int res = day, febDays = 28;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) febDays = 29;
        int[] monthDays = {31, febDays, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month; i++) res += monthDays[i];
        return res;
    }
}
