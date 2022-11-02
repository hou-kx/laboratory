package com.quincy.laboratory.exam.yongyou.q002;

import org.apache.commons.math3.analysis.function.Max;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> scList = new ArrayList<>();
        while (sc.hasNext()) {
            scList.add(sc.next().split(","));
        }
        int n = scList.size();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(maxArea(scList));
    }

    private static int maxArea(List<String[]> scList) {
        int ans = 0;
        for (int i = 0; i != scList.size(); i++) {
            for (int j = 0; j != scList.get(0).length; j++) {
                ans = Math.max(ans, dfs(scList, i, j));
            }
        }
        return ans;
    }

    private static int dfs(List<String[]> scList, int i, int j) {
        if (i < 0 || j < 0 || i == scList.size() || j == scList.get(0).length || !scList.get(i)[j].equals("1")) {
            return 0;
        }
        scList.get(i)[j] = "0";
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        int ans = 1;
        for (int index = 0; index < 4; index++) {
            int nextI = i + di[index];
            int nextJ = j + dj[index];
            ans += dfs(scList, nextI, nextJ);
        }
        return ans;
    }


    public long calculateTotal(int count) {
        // write code here
        if (count <= 2) {
            return 1;
        }
        int a = 1, b = 1;
        for (int i = 3; i <= count; i++) {
            int temp = b;
            b += a;
            a = temp;
        }
        return b;
    }

    public int[] findBuilding(int[] heights) {
        // write code here
        int len = heights.length;

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            Stack<Integer> stackLeft = new Stack<>();
            Stack<Integer> stackRight = new Stack<>();
            for (int l = i - 1; l > 0; l--) {
                if (stackLeft.isEmpty() || stackLeft.peek() < heights[l]) {
                    stackLeft.push(l);
                }
            }
            for (int r = i + 1; r < len; r++) {
                if (stackRight.isEmpty() || stackRight.peek() < heights[r]) {
                    stackRight.push(r);
                }
            }
            res[i] = stackLeft.size() + stackRight.size() + 1;
        }
        return res;
    }
}
