package com.quincy.laboratory.leetcode.commonFunc;

import java.util.LinkedList;
import java.util.List;

public class DFS {
    List<List<Integer>> allPath = new LinkedList<>();
    List<Integer> curPath = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        curPath.add(0);
        DFSPath(graph, 0, graph.length - 1);
        return allPath;
    }

    public void DFSPath(int[][] graph, int cur, int n) {
        // 一直找到目标节点即最后一个节点
        if (cur == n) {
            allPath.add(new LinkedList<>(curPath));
            return;
        }
        // 遍历当前节点的所有下个节点， 利用回溯法，遍历所有的分支
        for (int next : graph[cur]) {
            curPath.add(next);
            DFSPath(graph, next, n);
            curPath.remove(curPath.size() - 1);
        }
    }
}
