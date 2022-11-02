package com.quincy.laboratory.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class TreePath {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<>();
        addPath(root, "", pathList);
        return pathList;
    }

    private void addPath(TreeNode root, String path, List<String> pathList) {
        if (root != null) {
            path += root.val;
            if (root.left == null && root.right == null) {
                pathList.add(path);
            } else {
                path += "->";
                addPath(root.left, path, pathList);
                addPath(root.right, path, pathList);
            }
        }
    }
}
