package com.example.acmlearn.service;

/**
 * 104. 二叉树的最大深度 第一遍 DFS 通过 0ms
 */
public class Test104_01 {
    /**
     * Definition for a binary tree node.*/
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
         private int maxDepth = 0;
         public int maxDepth(TreeNode root) {
            dfs(root,0);
            return maxDepth;
         }

         private void dfs(TreeNode node, Integer depth){
            if (node == null) return;
            depth++;
            if (node.left == null && node.right == null) {
                maxDepth = maxDepth < depth ? depth : maxDepth;
                return;
            }
            dfs(node.left, depth);
            dfs(node.right, depth);
         }
    }
}
