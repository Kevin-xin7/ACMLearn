package com.example.acmlearn.service;

import java.util.HashSet;
import java.util.Set;

/**
 * 50. Pow(x, n) 第三遍-复习
 * 暴力法:f(n) = f(n-1) * x 超时
 * 分治：快速幂算法——递归 通过
 */
public class Test50_03 {
    class Solution {
        public double myPow(double x, int n) {
            //输入：x = 2.10000, n = 3 输出：9.26100
            // x = 2.00000, n = -2 输出：0.25000
            //二进制方案
            long y = n;
            double ret = 1.0;
            if (n < 0) {
                x = 1 / x;
                y = -y;
            }
            while (y != 0) {
                if((y & 1) == 1){
                    ret = ret * x;
                }
                x = x * x;
                y = y >> 1;
            }
            return ret;
        }

        }

    public static void main(String[] args) {
        Test50_03.Solution solution = new Test50_03().new Solution();
        System.out.println(solution.myPow(2.10000, 3));
        System.out.println(solution.myPow(2.00000, -2));
    }
}
