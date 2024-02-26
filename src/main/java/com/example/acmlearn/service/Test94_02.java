package com.example.acmlearn.service;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 94. 二叉树的中序遍历 第二遍 迭代法
 */
public class Test94_02 {

//      Definition for a binary tree node.
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            while (!stack.isEmpty() || root!=null) {
                //先往左，走一步进一次栈;走不动了，出栈，打印，再往右走
                if(root != null) {
                    stack.push(root);
                    root = root.left;
                }else {
                    TreeNode tmp = stack.pop();
                    result.add(tmp.val);
                    root = tmp.right;
                }
            }
            return result;
        }
    }
}
