package com.example.acmlearn.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 429. N 叉树的层序遍历 第三遍 DFS
 */
public class Test429_03 {
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

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null){
            return res;
        }
        dfs(root,0);
        return res;
    }
    void dfs(Node node, Integer deep) {
        if (node == null) return;
        if (res.size() < deep + 1) res.add(new ArrayList<>());
        res.get(deep).add(node.val);
        deep++;
        for (Node child : node.children) {
            dfs(child,deep);
        }
    }
}

