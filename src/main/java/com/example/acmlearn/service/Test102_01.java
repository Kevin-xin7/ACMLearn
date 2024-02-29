package com.example.acmlearn.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历 第1遍 DFS
 */
public class Test102_01 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

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

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return res;
        }
        dfs(root,0);
        return res;
    }
    void dfs (TreeNode node, int deep) {
        if (node == null) return;
        if (res.size() < deep +1) res.add(new ArrayList<>());
        res.get(deep).add(node.val);
        deep++;
        dfs(node.left,deep);
        dfs(node.right,deep);
    }

}

