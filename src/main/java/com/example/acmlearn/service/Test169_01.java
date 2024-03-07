package com.example.acmlearn.service;

import java.util.HashMap;

/**
 * 169. 多数元素
 *  哈希法
 */
public class Test169_01 {

    class Solution {
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int ret = 0;
            for (int i = 0; i < nums.length; i++) {
                int count = map.getOrDefault(nums[i], 0) + 1;
                if (count > nums.length / 2) {
                    ret = nums[i];
                    break;
                }
                map.put(nums[i], count);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        Test169_01.Solution solution = new Test169_01().new Solution();
        int[] nums = new int[3];
        nums[0] = 3;
        nums[1] = 2;
        nums[2] = 3;
        solution.majorityElement(nums);
    }
}
