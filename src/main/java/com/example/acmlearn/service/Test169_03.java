package com.example.acmlearn.service;

import java.util.Arrays;

/**
 * 169. 多数元素
 *  摩尔投票法
 */
public class Test169_03 {

    class Solution {
        public int majorityElement(int[] nums) {
            int candidate = nums[0], count = 0;
            for (int num : nums) {
                if(num == candidate){
                    count++;
                }else {
                    count--;
                }
                if (count < 0) {
                    candidate = num;
                    count = 1;
                }
            }
            return candidate;
        }
    }

    public static void main(String[] args) {
        Test169_03.Solution solution = new Test169_03().new Solution();
        int[] nums = new int[3];
        nums[0] = 3;
        nums[1] = 2;
        nums[2] = 3;
        solution.majorityElement(nums);
    }
}
