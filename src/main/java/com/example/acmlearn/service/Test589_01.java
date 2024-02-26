package com.example.acmlearn.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N 叉树的前序遍历 第一遍试写-递归法 通过
 */
public class Test589_01 {
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
    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> res = new ArrayList<>();
            find(root,res);
            return res;
        }

        void find(Node root, List<Integer> res) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            for (Node child : root.children) {
                find(child,res);
            }
        }
    }
}
