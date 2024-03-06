package com.example.acmlearn.service;


/**
 * 98. 验证二叉搜索树 第二遍 尝试中序遍历
 * 二叉搜索树的中序遍历节点val永远递增 左 < 中 < 右
 */
public class Test98_02 {

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
        TreeNode lastNode;
        public boolean isValidBST(TreeNode root) {
            rec(root);
            return iftrue;
        }

        void rec(TreeNode root){
            //终止条件
            if (root == null) {
                return;
            }
            if (root != null && root.left == null && lastNode == null) {
                lastNode = root;
            }
            rec(root.left);
            if (root != lastNode && root.val <= lastNode.val) {
                iftrue = false;
                return;
            }
            lastNode = root;
            rec(root.right);
        }
    }
}
