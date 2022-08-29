package com.quincy.laboratory.weilai.q001;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        int res = 0;
        for (String str : paths) {
            res += Integer.parseInt(str);
        }
        return res;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder pathSB = new StringBuilder(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                //pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }

    public void main1(String[] args) {
        int[] preorder = {1, 2, 3};
        int[] inorder = {2, 1, 3};
        TreeNode root = new TreeNode();
        root = root.buildTree(preorder, inorder);

        int res = 0;

        // List<String> resList = binaryTreePaths(root);
//        for (String str : resList) {
//            res += Integer.parseInt(str);
//        }
//
//        System.out.println(resList);
//        System.out.println(res);

    }
}