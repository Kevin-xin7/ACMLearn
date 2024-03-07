package com.example.acmlearn.service;

/**
 * 50. Pow(x, n)
 * 暴力法:f(n) = f(n-1) * x 超时
 * 分治：快速幂算法——递归 通过
 */
public class Test50_01 {
    class Solution {
        public double myPow(double x, int n) {
//            if (n == 0) return 1;
//            if(n < 0) {
//                x = 1 / x;
//                n = -n;
//            }
            //输入：x = 2.10000, n = 3 输出：9.26100
            // x = 2.00000, n = -2 输出：0.25000

            //限制res为5位小数
//            res = Math.round(res * 100000.0) / 100000.0;
//            return pow(x,n);
            return n >= 0 ? pow(x,n) : 1.0 / pow(x,-n);
        }

        public double pow(double x, long n){
            if (n == 0) {
                return 1.0;
            }
            //分治:划分子问题
            double half = pow(x,n / 2);
            //合并结果
            return n % 2 == 0 ? half * half : half * half * x;
        }
    }
    public static void main(String[] args) {
        Test50_01.Solution solution = new Test50_01().new Solution();
        System.out.println(solution.myPow(2.10000, 3));
        System.out.println(solution.myPow(2.00000, -2));
    }
}
