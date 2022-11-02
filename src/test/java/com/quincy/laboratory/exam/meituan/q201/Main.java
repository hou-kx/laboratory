package com.quincy.laboratory.exam.meituan.q201;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int k = sc.nextInt();
            double mei = (double) k / x;
            double friends = (double) (n - k + 1) / y;
            if (mei == friends) strList.add("Tie");
            if (mei > friends) strList.add("Lose");
            if (mei < friends) strList.add("Win");
        }
        for (String s : strList) {
            System.out.println(s);
        }
    }

    public static void main1(String[] args) {
        // 1.数据输入
        Scanner in = new Scanner(System.in);
        // 读入 n 个数字
        int numLen = in.nextInt();
        int[] numArr = new int[numLen];
        int i = 0;
        while (in.hasNextInt() && i < numLen) {
            numArr[i] = in.nextInt();
            i++;
        }

        // 读字符串, (长度)
        int strLen = in.nextInt();
        in.nextLine(); //数字到字符串要换行
        String[] strArr = new String[strLen];
        // 或者 strArr[] = in.nextLine().split(" ");
        int j = 0;
        while (in.hasNextLine() && j < strLen) {
            strArr[j] = in.nextLine();
            j++;
        }

        // 2. 处理  ···
        // 3. 输出
        System.out.println("result ``` ");

        // 格式化输出，四舍五入输出小数
        String str = String.format("%.2f", 3.555);
        System.out.println(str);
    }


}

