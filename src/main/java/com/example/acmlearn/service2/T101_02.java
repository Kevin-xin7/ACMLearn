package com.example.acmlearn.service2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 101. 对称二叉树 —— 第二遍
 * 思路：通过递归判断左右子树的值是否相等、左子树的左子树的值和右子树的右子树的值是否相等、左子树的右子树和右子树的左子树的值是否相等
 */
public class T101_02 {
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left,root.right);
    }

    boolean dfs(TreeNode l, TreeNode r) {
        if (l == null || r == null) {
            return l == r;
        }
        return l.val == r.val && dfs(l.left,r.right) && dfs(l.right,r.left);
    }
}
