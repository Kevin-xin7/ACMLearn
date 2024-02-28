package com.example.acmlearn.service;

import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 * 429. N 叉树的层序遍历 第二遍 BFS
 */
public class Test429_02 {
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //一层层的消费，每次进入while队列里都是父节点,cnt记录了本层父节点的数量
            int cnt = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                Node node = queue.poll();
                level.add(node.val);
                if (null != node.children && node.children.size() > 0) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            res.add(level);
        }
        return res;
    }
}

