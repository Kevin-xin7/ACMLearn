package com.example.acmlearn.service2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 101. 对称二叉树 —— 第一遍 失败
 * 思路：BFS检查每层int[i]和int[length - i]是否相等，不相等返回false，否则最后返回true
 * 问题：BFS遍历每层只能判断值是否相同，无法判断是否对称，如果用0占位空位的话，时间复杂度是2^n，会超时
 */
public class T101_01 {
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
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root.left == null & root.right != null) return false;
        if (root.right == null & root.left != null) return false;
        if (root.left == null && root.right == null) return true;
        queue.offer(root.left);
        queue.offer(root.right);
        while (queue.size() != 0) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }else {
                    queue.offer(new TreeNode(0));
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }else {
                    queue.offer(new TreeNode(0));
                }
            }
            if (list.size() % 2 == 1) return false;
            for (int i = 0, j = list.size()-1 ; i < j; i++,j--) {
                if (list.get(i) != list.get(j)) return false;
            }
        }
        return true;
    }
}
