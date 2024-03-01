package com.example.acmlearn.service;

/**
 * 70. 爬楼梯 第一遍 递归——超时
 * https://leetcode.cn/problems/climbing-stairs/
 */
public class Test70_01 {
    public int climbStairs(int n) {
        // 递归法f(n) = f(n-1) + f(n-2)
        return f(n);
    }
    int f(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        return f(n-1) + f(n-2);
    }
}
//2023-12-01 第二遍
//思路：动态规划-滚动数组
//        if(n == 1) return 1;
//        if(n == 2) return 2;
//        //   f(0)  f(1)   f(2)
//        int a = 0, b = 1, c = 2;
//        for(int i = 3; i <= n;i++) {
//            a = b;
//            b = c;
//            c = a + b;
//        }
//        return c;