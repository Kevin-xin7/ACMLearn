package com.example.acmlearn.service;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 169. 多数元素
 *  排序法
 */
public class Test169_02 {

    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length >> 1];
        }
    }

    public static void main(String[] args) {
        Test169_02.Solution solution = new Test169_02().new Solution();
        int[] nums = new int[3];
        nums[0] = 3;
        nums[1] = 2;
        nums[2] = 3;
        solution.majorityElement(nums);
    }
}
