package com.example.acmlearn.service;

/**
 * 98. 验证二叉搜索树 第一遍 定义递归 未通过
 * 未通过原因：只保证了当前子树为二叉搜索树，没有考虑到根的右子树上某个左子树节点小于根的左子树上某个节点的情况
 */
public class Test98_01 {

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
        private boolean iftrue = true;
        public boolean isValidBST(TreeNode root) {
            rec(root);
            return iftrue;
        }

        void rec(TreeNode root){
            //终止条件
            if (root == null) return;
            //处理逻辑
            if (root.left != null && root.left.val >= root.val ) iftrue = false;
            if (root.right != null && root.right.val <= root.val) iftrue = false;
            //递归
            if (root.left != null) rec(root.left);
            if (root.right != null) rec(root.right);
        }
    }
}
