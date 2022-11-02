package com.quincy.laboratory.exam.Bankzhongxin.q003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                int x = n - i - 1;
                int y = n - j - 1;
                matrix[i][j] = matrix[x][y];
                matrix[x][y] = tmp;
            }
        }

        for (int[] arr : matrix){
            for (int a :arr){
                System.out.print(a + " ");
            }
            System.out.println("");
        }
    }
}
