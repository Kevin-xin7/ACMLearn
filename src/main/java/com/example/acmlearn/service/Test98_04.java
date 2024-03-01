package com.example.acmlearn.service;

import com.sun.org.apache.bcel.internal.generic.IRETURN;

/**
 * 98. 验证二叉搜索树 第四遍 ——改进递归法
 */
public class Test98_04 {

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
        public boolean isValidBST(TreeNode root) {
            return rec(root, Long.MIN_VALUE,Long.MAX_VALUE);
        }

        boolean rec(TreeNode root, long lowwer, long upper){
            //终止条件
            if (root == null) return true;
            //处理逻辑
            if(root.val <= lowwer || root.val >= upper) return false;
            //递归
            return rec(root.left,lowwer,root.val) && rec(root.right, root.val,upper);
        }
    }
}
