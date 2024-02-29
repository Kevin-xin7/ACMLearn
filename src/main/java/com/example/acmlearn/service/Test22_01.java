package com.example.acmlearn.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成 第一遍 回溯dfs
 */
public class Test22_01 {
    class Solution {
        List<String> res = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            if (n == 0){
                return res;
            }
            dfs("",n,n);
            return res;
        }
        void dfs(String curS, int left, int right) {
            if(left == 0 && right == 0) {
                res.add(curS);
                return;
            }
            if(left > right) return;
            if(left > 0) {
                dfs(curS + "(",left-1,right);
            }
            if(right > 0) {
                dfs(curS + ")",left,right-1);
            }
        }
    }
}
