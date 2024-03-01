package com.example.acmlearn.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成 第二遍 递归
 */
public class Test22_02 {
    class Solution {
        List<String> res = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            if (n == 0) return res;
            dfs("",n,n);
            return res;
        }
        void dfs(String curS, int left, int right) {
            //返回条件
            if ( left == 0 && right == 0) {
                res.add(curS);
                return;
            }
            if (left > 0) dfs(curS + "(", left-1, right);
            if (right > left) dfs(curS + ")", left, right-1);
        }
    }
}
