package com.example.acmlearn.service2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 297. 二叉树的序列化与反序列化 第二遍 BFS 通过
 */
public class Test297_02 {

     // Definition for a binary tree node.
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return "";
            StringBuilder sb = new StringBuilder();
//            Deque<TreeNode> queue = new ArrayDeque<>();
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val + ",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }else {
                    sb.append("null,");
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public static TreeNode deserialize(String data) {
            if(data == "") return null;
            String[] list = data.substring(0,data.length()-1).split(",");
            TreeNode root = new TreeNode(0);

            int cnt = 0;
            Deque<TreeNode> queue = new ArrayDeque<>();
            root.val = Integer.valueOf(list[cnt++]);
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(!"null".equals(list[cnt])) {
                     node.left = new TreeNode(Integer.valueOf(list[cnt]));
                     queue.offer(node.left);
                }
                cnt++;
                if(!"null".equals(list[cnt])) {
                    node.right = new TreeNode(Integer.valueOf(list[cnt]));
                    queue.offer(node.right);
                }
                cnt++;
            }
            return root;
    }



// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
