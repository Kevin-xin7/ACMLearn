package com.example.acmlearn.service;

import javax.xml.soap.Node;
import java.util.*;

/**
 * 429. N 叉树的层序遍历 28/38 未通过
 */
public class Test429_01 {
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
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> levelList = new ArrayList<>();
        if (root == null){
            return levelList;
        }
        Deque<Node> stack = new ArrayDeque<>();
        Set<Node> set = new HashSet<>();
        stack.push(root);
        int level = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> valAndlevelMap = new HashMap<>();
        valAndlevelMap.put(root.val,level);
        while (!stack.isEmpty()) {
            Node tmp = stack.peek();
            //如果没有访问过这个节点，则添加进对应level的List中
            if(!set.contains(tmp)) {
                //只要是除了第一次root的新节点，就level++
                if(tmp != root) {
                    level ++;
                }
                List<Integer> list = map.getOrDefault(level, new ArrayList<>());
                list.add(tmp.val);
                map.put(level,list);
                valAndlevelMap.put(tmp.val,level);
                res.add(tmp.val);
            }
            /* 如果当前节点为叶子节点，则level--，出栈并返回父节点 */
            if(tmp.children.size() == 0) {
                stack.pop();
                continue;
            }
            /* 如果当前节点已经遍历过,说明当前节点为老节点,则leve置为原值，出栈并返回它的子节点*/
            if (set.contains(tmp)) {
                stack.pop();
                level = valAndlevelMap.get(tmp.val);
                continue;
            }
            List<Node> children = tmp.children;
            //将子节点按从右到左的顺序入栈，这样出栈的顺序就是需要的从左到右
            //1 /14 12 13/ 36 35
            //1 /
            // 2
            for(int i = children.size() -1; i >= 0; i--) {
                stack.push(tmp);
                stack.push(children.get(i));
            }
            //代表当前节点已经访问过 后续再访问不用添加子节点，直接出栈并记录值
            set.add(tmp);
        }
        levelList.addAll(map.values());
        return levelList;
    }
}

