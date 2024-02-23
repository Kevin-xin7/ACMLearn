package com.example.acmlearn.service;

import java.util.Arrays;
import java.util.List;

/**
 * 3数之和
 */
public class Sum3_2 {
        public List<List<Integer>> threeSum(int[] nums) {
            //2023-12-01
            //思路1: 排序 + 暴力求解 + 双指针法
            //思考指针快速跳过的触发条件:
            //1、重复的数字跳过
            //2、nums[i] 就已经 > 0了
            Arrays.sort(nums);
            List<List<Integer>> sums = new java.util.ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i-1]) continue;
                int j = i + 1,k = nums.length -1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum > 0) {
                        while (j < k && nums[k] == nums[--k]) ;
                    } else if (sum < 0) {
                        while (j < k && nums[j] == nums[++j]) ;
                    } else {
                        sums.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[k] == nums[--k]) ;
                        while (j < k && nums[j] == nums[++j]) ;
                    }
                }
            }
            return sums;
        }
}
