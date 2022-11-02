package com.quincy.laboratory.leetcode.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            return left == null ? right : (right == null ? left : root);
        }
    }

    /**
     * p , q 的最近公共祖先
     * 1、若 root 为空查找失败直接返回 root，若 root 等于 p q 中的一个，原因如下
     * 2、一直进行左右节点递归，直到 null p q 其中一个结果
     * 3、左右节点若都不为空，则 p q 分居 root 两侧，root 为最近公共祖先
     * 4、若其中有一个为空，则 p q 必然在另外的子树上，1）root 指向 p 或 q，另一个在 root 不为空的子树上，2）root就是 p q 最近公共祖先
     */
    TreeNode ancestor;

    Solution() {
        ancestor = null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ancestor;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean isLeft = dfs(root.left, p, q);
        boolean isRight = dfs(root.right, p, q);
        if ((isLeft && isRight) || ((root.val == p.val || root.val == q.val) && (isLeft || isRight))) {
            ancestor = root;
        }
        return isLeft || isRight || (root.val == p.val || root.val == q.val);
    }

    /**
     * 这里是自底向上，找到最近祖先 ancestor 操作之后，此轮递归必然返回 true
     * 即认为当前子树存在 p q 中的一个，这样其他的祖先必然无法满足同时满足公共祖先这个条件了。
     */

    Map<Integer, TreeNode> parentMap;
    Set<Integer> visited;

    void Solution1() {
        parentMap = new HashMap<>();
        visited = new HashSet<>();
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        dfs1(root);
        while (p != null) {
            visited.add(p.val);
            p = parentMap.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parentMap.get(q.val);
        }
        return null;
    }

    private void dfs1(TreeNode root) {
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            dfs1(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            dfs1(root.right);
        }
    }
}
