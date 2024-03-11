package com.example.acmlearn.service2;


import java.util.*;
import java.util.stream.Collectors;


/**
 * 297. 二叉树的序列化与反序列化 第一遍 报错 未通过
 * 基础太差了，没有经验 使用StringBuilder和String[]就可以，跑去用List<String>，还要考虑List->String和String->List
 */
public class Test297_01 {

     // Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            String res = new String();
            if(root == null) return res;
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size;i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        list.add(null);
                        continue;
                    }else {
                        list.add(node.val);
                        if (node.left != null) queue.offer(node.left);
                        if (node.right != null) queue.offer(node.right);
                    }
                }
            }
            res = list.toString();
            return res;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data == null) return null;
            System.out.println(data);
            List<Integer> list = new ArrayList<>();
            TreeNode root = new TreeNode(0);

            list = Arrays.stream(data.substring(1,data.length()-1).trim().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int cnt = 0;
            Deque<TreeNode> queue = new ArrayDeque<>();
            root.val = list.get(cnt++);
            queue.offer(root);
            while (!queue.isEmpty() && cnt < list.size()){
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    TreeNode node = queue.poll();
                    TreeNode left = new TreeNode(list.get(cnt++));
                    TreeNode right = new TreeNode(list.get(cnt++));
                    node.left = left;
                    node.right = right;
                    queue.offer(left);
                    queue.offer(right);
                }
            }

            return root;
        }
    }



// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
