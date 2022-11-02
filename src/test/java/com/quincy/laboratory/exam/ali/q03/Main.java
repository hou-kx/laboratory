package com.quincy.laboratory.exam.ali.q03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[] strings = new String[n];
            for (int j = 0; j < n; j++) {
                strings[j] = sc.next();
            }
            System.out.println(isSatisfied(strings) ? "Yes" : "No");
        }
    }

    private static boolean isSatisfied(String[] strings) {
        List<char[]> matrix = new ArrayList<>();
        for (String str : strings) matrix.add(str.toCharArray());
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).length; j++) {
                if (matrix.get(i)[j] == '.') continue;
                int sum = 0;
                sum += (i > 0 && j > 0) ? (matrix.get(i - 1)[j - 1] == '*' ? 1 : 0) : 0;
                sum += (i > 0) ? (matrix.get(i - 1)[j] == '*' ? 1 : 0) : 0;
                sum += (i > 0 && j + 1 < matrix.get(i).length) ? (matrix.get(i - 1)[j + 1] == '*' ? 1 : 0) : 0;
                sum += (j > 0) ? (matrix.get(i)[j - 1] == '*' ? 1 : 0) : 0;
                sum += (j + 1 < matrix.get(i).length) ? (matrix.get(i)[j + 1] == '*' ? 1 : 0) : 0;
                sum += (i + 1 < matrix.size() && j > 0) ? (matrix.get(i + 1)[j - 1] == '*' ? 1 : 0) : 0;
                sum += (i + 1 < matrix.size()) ? (matrix.get(i + 1)[j] == '*' ? 1 : 0) : 0;
                sum += (i + 1 < matrix.size() && j + 1 < matrix.get(i).length) ? (matrix.get(i + 1)[j + 1] == '*' ? 1 : 0) : 0;
                if (sum > 3) return false;
            }
        }
        return true;
    }
}
