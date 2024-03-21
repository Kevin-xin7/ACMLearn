package com.example.acmlearn.service2;

/**
 * 230. 二叉搜索树中第K小的元素 —— 第一遍 通过
 * 思路：二叉搜索树的中序遍历是从小到大升序排列，返回第k个元素的值就行了
 */
public class T230_01 {
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
    private int res = 0;
    private int num = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }

    void dfs(TreeNode root, int k) {
        if (root == null) return;

        dfs(root.left,k);
        num++;
        if (k == num){
            res = root.val;
        }
        dfs(root.right,k);
    }

}
