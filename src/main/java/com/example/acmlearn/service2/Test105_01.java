package com.example.acmlearn.service2;

import java.util.HashMap;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 前序-中、左、右 [3,9,20,15,7]
 * 中序-左、中、右 [9,3,15,20,7]
 */
public class Test105_01 {
    class Solution {
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

        HashMap<Integer, Integer> map = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length;i++) {
                map.put(inorder[i],i);
            }
            return buildTreeNode(preorder,0,preorder.length,inorder,0,inorder.length);
        }

        public TreeNode buildTreeNode(int[] preorder,int p_start,int p_end,
                                      int[] inorder,int i_start,int i_end) {
            if (p_start == p_end) return null;
            TreeNode root = new TreeNode(preorder[p_start]);
            int root_index = map.get(root.val);
            int leftNum = root_index -i_start;
            root.left = buildTreeNode(preorder,p_start +1, p_start + 1 +leftNum, inorder, i_start, root_index);
            root.right = buildTreeNode(preorder, p_start + 1 + leftNum, p_end, inorder, root_index + 1, i_end);
            return root;
        }
    }
}
