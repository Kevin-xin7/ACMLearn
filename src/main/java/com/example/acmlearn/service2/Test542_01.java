package com.example.acmlearn.service2;

import javax.swing.*;

/**
 * 543. 二叉树的直径
 */
public class Test542_01 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
    int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int llen = dfs(node.left) + 1;
        int rlen = dfs(node.right) + 1;
        ans = Math.max(ans, llen + rlen + 1);
        return Math.max(llen,rlen);
    }
}
