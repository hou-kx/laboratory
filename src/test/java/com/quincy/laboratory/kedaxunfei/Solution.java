package com.quincy.laboratory.kedaxunfei;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.*;

@SpringBootTest
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 求取指定长度序列的和
     *
     * @param n int整型 序列长度
     * @return float浮点型
     */
    public float seqSum(int n) {
        // write code here
        if (n < 1) {
            return -1;
        }
        float a = 1, b = 2;
        float res = a / b;
        for (int i = 1; i < n; i++) {
            float temp = b;
            b += a;
            a = temp;
            res += a / b;
        }
        // 保留两位小数
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return Float.parseFloat(decimalFormat.format(res));
    }

    public boolean signalVerify(String signal) {
        // write code here
        int len = signal.length();
        if (len < 3) {
            return false;
        }
        if (signal.charAt(0) >= 'a' && signal.charAt(0) <= 'z'
                && signal.charAt(1) == '=' && signal.charAt(2) != ' ') {
            for (int i = 2; i < len; i++) {
                if ((signal.charAt(i) >= 'a' && signal.charAt(i) <= 'z')
                        || (signal.charAt(i) >= '0' && signal.charAt(i) <= '9')
                        || signal.charAt(i) == ' ') {
                    continue;
                } else {
                    break;
                }
            }
            return true;
        }
        return false;
    }


    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public ArrayList<Point> winMazeGift(int[][] maze) {
        // write code here
        // 最短路径使用 迪杰斯特拉算法可以求解
        // 递归所有路径，选择一条最短路径
        int len = maze.length;
        if (len < 1) {
            return new ArrayList<>();
        }
        // 先找到所有可能入口
        ArrayList<Point> enter = new ArrayList<>();
        // 顶行
        for (int i = 0; i < len; i++){
            if (maze[0][i] == 0){
                enter.add(new Point(0, i));
            }
        }
        // 底行
        for (int i = 0; i < len; i++){
            if (maze[len - 1][i] == 0){
                enter.add(new Point(len - 1, i));
            }
        }
        // 左列
        for (int i = 1; i < len - 1; i++){
            if (maze[i][0] == 0){
                enter.add(new Point(i, 0));
            }
        }
        // 右列
        for (int i = 1; i < len -1; i++){
            if (maze[i][len - 1] == 0){
                enter.add(new Point(i, len - 1));
            }
        }
        // 找路径
        ArrayList<Point> res = new ArrayList<>();

        for (Point p : enter){

        }
        res.add(new Point(0, 0));
        return res;
    }

    @Test
    public void test() {
        System.out.println(signalVerify("v=0"));
        System.out.println(signalVerify("t=0 0"));
        System.out.println(signalVerify(""));
    }
}