package com.example.acmlearn.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成 第二遍 递归
 */
public class Test22_03 {
    class Solution {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        public List<String> generateParenthesis(int n) {
            if (n == 0) return res;
            dfs(sb,n,n);
            return res;
        }
        void dfs(StringBuilder sb, int left, int right) {
            //终止条件
            if (left == 0 && right == 0) {
                res.add(sb.toString());
                return;
            }
            if (left > 0) {
                dfs(sb.append("("), left -1, right);
                sb.deleteCharAt(sb.length() -1);
            }
            if (right > left) {
                //递归
                dfs (sb.append(")") , left, right -1);
                //恢复环境
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
