package com.example.acmlearn.service;

/**
 * 98. 验证二叉搜索树 第二遍 中序遍历
 * 二叉搜索树的中序遍历节点val永远递增 左 < 中 < 右
 * 简化lastNode的初始化
 */
public class Test98_03 {

    //Definition for a binary tree node.
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

    class Solution {
        long pre = Long.MIN_VALUE;
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isValidBST(root.left)) return false;
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            return isValidBST(root.right);
        }
    }
}
