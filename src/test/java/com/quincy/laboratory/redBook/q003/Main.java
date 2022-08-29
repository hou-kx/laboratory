package com.quincy.laboratory.redBook.q003;

import java.util.Scanner;

public class Main {
    static boolean[] path;
    static boolean[] visited;
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n - 1];
        path = new boolean[n - 1];
        visited = new boolean[n - 1];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        int[][] graph = buildGraph(n, a);
        for (int i = 0; i < graph.length; i++) {
            visitGraph(graph, i);
        }
        System.out.println(res - 1);
    }

    public static void visitGraph(int[][] graph, int i) {
        if (path[i]) {
            res++;
        }
        if (visited[i]) {
            return;
        }
        path[i] = visited[i] = true;
        for (int v = 0; v < graph[0].length; v++) {
            visitGraph(graph, v);
        }
        path[i] = false;
    }

    public static int[][] buildGraph(int n, int[] a) {
        int[][] res = new int[n - 1][2];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = j == 0 ? a[i] : i + 1;
            }
        }
        return res;
    }
}
