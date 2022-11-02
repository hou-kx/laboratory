package com.quincy.laboratory.exam.qqmusic;

import com.quincy.laboratory.leetcode.tree.TreeNode;

import java.util.*;

public class Solution {
    List<Integer> preorder;
    List<Integer> inorder;
    Map<Integer, List<Integer>> inorderIndexMap = new HashMap<>();
    List<List<Integer>> allPath = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] isUsed;
    int usedCount = 0;

    public ArrayList<TreeNode> getBinaryTrees(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        // write code here
        preorder = preOrder;
        inorder = inOrder;
        isUsed = new int[inOrder.size()];
        // 记录下所有相同节点值得下标
        for (int i = 0; i < inorder.size(); i++) {
            if (inorderIndexMap.get(inorder.get(i)) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                inorderIndexMap.put(inorder.get(i), list);
            } else {
                inorderIndexMap.get(inorder.get(i)).add(i);
            }
        }
        buildTrees(0, 0, inorder.size() - 1);
        ArrayList<TreeNode> allRoots = new ArrayList<>();
        for (List<Integer> path : allPath) {
            allRoots.add(buildTreeByList(path));
        }
        return allRoots;
    }

    private TreeNode buildTreeByList(List<Integer> path) {
        int size = path.size();
        TreeNode root = null;
        for (int i = 0; i < size; i++) {
            TreeNode curNode = new TreeNode(path.get(i));
            if (i == 0) root = curNode;
            if ((2 * (i + 1) - 1) < size) {
                curNode.left = (path.get((2 * (i + 1) - 1))) == null ? null : new TreeNode(path.get((2 * (i + 1) - 1)));
            }
            if ((2 * (i + 1) + 1) < size) {
                curNode.right = (path.get((2 * (i + 1) + 1))) == null ? null : new TreeNode(path.get((2 * (i + 1) + 1)));
            }
        }
        return root;
    }

    TreeNode buildTrees(int root, int left, int right) {
        if (left > right) {
            path.add(null);
            return null;  // 递归终止
        }
        // 判断当前树是否建立完成,所有节点都是 isUsed
        if (usedCount == isUsed.length) {
            allPath.add(new ArrayList<>(path));
        }
        TreeNode node = new TreeNode(preorder.get(root));      // 建立根节点
        // root left right  ->
        path.add(root);
        // 找到中序遍历的节点的下标, 多个则用回溯法进行
        for (int i : inorderIndexMap.get(preorder.get(root))) {
            // 划分根节点、左子树、右子树
            if (isUsed[i] == 1) {
                continue;
            }
            isUsed[i] = 1;
            usedCount++;
            node.left = buildTrees(root + 1, left, i - 1);                // 开启左子树递归
            node.right = buildTrees(root + i - left + 1, i + 1, right);    // 开启右子树递归
            isUsed[i] = 0;
            usedCount--;
        }
        return node;    // 回溯返回根节点
    }
}
