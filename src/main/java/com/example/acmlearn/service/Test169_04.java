package com.example.acmlearn.service;

import java.util.HashMap;

/**
 * 169. 多数元素
 *  分治法
 */
public class Test169_04 {

    class Solution {
        public int majorityElement(int[] nums) {
            int ret = 0;
            ret = dfs(nums,0,nums.length-1);
            return ret;
        }
        private int dfs(int[] nums, int start, int end) {
            if (start == end){
                return nums[start];
            }
            int mid = (start + end) / 2;
            int left = dfs(nums, start, mid);
            int right = dfs(nums, mid+1, end);
            if (left == right){
                return left;
            }else {
                int leftCount = 0;
                int rightCount = 0;
                for (int i = start; i <= end; i++) {
                    if (nums[i] == left){
                        leftCount++;
                    }
                    if (nums[i] == right){
                    rightCount++;
                    }
                }
                return leftCount > rightCount ? left : right;
            }
        }
    }

    public static void main(String[] args) {
        Test169_04.Solution solution = new Test169_04().new Solution();
        int[] nums = new int[3];
        nums[0] = 3;
        nums[1] = 2;
        nums[2] = 3;
        System.out.println(solution.majorityElement(nums));
    }
}
