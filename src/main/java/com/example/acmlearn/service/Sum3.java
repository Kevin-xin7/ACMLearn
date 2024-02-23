package com.example.acmlearn.service;

import java.util.Arrays;
import java.util.List;

/**
 * 3数之和
 */
public class Sum3 {
        public List<List<Integer>> threeSum(int[] nums) {
            //2023-12-01
            //思路1: 排序 + 暴力求解 + 双指针法
            Arrays.sort(nums);
            List<List<Integer>> sums = new java.util.ArrayList<>();
            for (int i = 0; i < nums.length -2; i++) {
                if(nums[i]>0) break;
                if(i>0 && nums[i]==nums[i-1]) continue;
                int  j = i + 1, k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum < 0) {
                        //如果遇到重复值，则往右移动
                        while(j < k && nums[j] == nums[++j]);
                    }else if(sum > 0) {
                        //如果遇到重复值，则往左移动
                        while(j < k && nums[k] == nums[--k]);
                    }else {
                        List<Integer> list = new java.util.ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        sums.add(list);

                        while(j < k && nums[j] == nums[++j]);
                        while(j < k && nums[k] == nums[--k]);
                    }
                }
            }
            return sums;
        }
}
