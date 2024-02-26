package com.example.acmlearn.service;

import java.util.*;

/**
 * 590. N 叉树的前序遍历 第二遍——模拟栈
 */
public class Test589_02 {
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
            if (root == null){
                return res;
            }
            Deque<Node> stack = new ArrayDeque<>();
            Set<Node> set = new HashSet<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node tmp = stack.peek();
                if(!set.contains(tmp)) {
                    res.add(tmp.val);
                }
                /* 如果当前节点为叶子节点或者当前节点的子节点已经遍历过,则记录当前值并出栈 */
                if(tmp.children.size() == 0 || set.contains(tmp)) {
                    stack.pop();
                    continue;
                }
                List<Node> children = tmp.children;
                //将子节点按从右到左的顺序入栈，这样出栈的顺序就是需要的从左到右
                for(int i = children.size() -1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
                //代表当前节点已经访问过 后续再访问不用添加子节点，直接出栈并记录值
                set.add(tmp);
            }
            return res;
        }
    }
}
