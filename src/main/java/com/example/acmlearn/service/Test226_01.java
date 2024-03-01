package com.example.acmlearn.service;

public class Test226_01 {
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
        public TreeNode invertTree(TreeNode root) {
            invert(root);
            return root;
        }

        public void invert(TreeNode node) {
            if (node == null) return;
            if (node.left != null && node.right != null) {
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }else if (node.left != null && node.right == null) {
                node.right = node.left;
                node.left = null;
            }else if (node.right != null && node.left == null) {
                node.left = node.right;
                node.right = null;
            }
            invert(node.left);
            invert(node.right);
        }
    }
}
