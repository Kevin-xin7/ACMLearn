package com.example.acmlearn.service;

/**
 * 50. Pow(x, n)
 * 分治：快速幂算法——二进制
 */
public class Test50_2 {
    class Solution {
        public double myPow(double x, int n) {
            long y = n;
            if(n < 0) {
                x = 1 / x;
                y = -y;
            }
            double res = 1.0;
            while (y != 0) {
                if ((y & 1) != 0) {
                    res  *= x;
                }
                x *= x;
                y >>= 1;
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Test50_2.Solution solution = new Test50_2().new Solution();
        System.out.println(solution.myPow(2.10000, 3));
        System.out.println(solution.myPow(2.00000, -2));
    }
}
