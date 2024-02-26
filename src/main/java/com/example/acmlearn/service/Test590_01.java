package com.example.acmlearn.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历 第一遍试写-递归法 通过
 */
public class Test590_01 {
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
        public List<Integer> postorder(Node root) {
            List<Integer> res = new ArrayList<>();
            find(root,res);
            return res;
        }

        void find(Node root, List<Integer> res) {
            if (root == null) {
                return;
            }
            for (Node child : root.children) {
                find(child,res);
            }
            res.add(root.val);
        }
    }
}
