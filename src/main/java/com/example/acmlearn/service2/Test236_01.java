package com.example.acmlearn.service2;

import java.util.*;

/**
 * 236. 二叉树的最近公共祖先 第一遍
 * 思路：DFS中序遍历，记录找到p和q的节点列表，然后倒序遍历size较长(更深)的列表，如果它的某个元素同样存在于较短列表中，
 * 它就是最近共同祖先
 */
public class Test236_01 {

    class Solution {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }

        List<TreeNode> qList = new ArrayList<>();
        List<TreeNode> pList = new ArrayList<>();
        boolean qfind = true;
        boolean pfind = true;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode target = null;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            Set<TreeNode> visited = new HashSet<>();

            queue.offer(root);
            dfs(root,p,q);
            List<TreeNode> llist = qList.size() > pList.size() ? qList : pList;
            List<TreeNode> slist = qList.size() < pList.size() ? qList : pList;
            for (int i = slist.size()-1; i > 0; i--) {
                TreeNode shorter = slist.get(i);
                if (llist.contains(shorter)) {
                    target = shorter;
                    break;
                }
            }
            return target;
        }

        void dfs(TreeNode node, TreeNode p, TreeNode q) {
            if (node == null) {
                return;
            }

            dfs(node.left,p,q);
            if (qfind){
                qList.add(node);
                if (node.val == q.val) qfind = false;
            }
            if (pfind){
                pList.add(node);
                if (node.val == p.val) pfind = false;
            }
            dfs(node.right,p,q);
        }
    }
}
