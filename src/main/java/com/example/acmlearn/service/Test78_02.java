package com.example.acmlearn.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 78、子集
 *  回溯算法
 */
public class Test78_02 {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            if(nums.length==0) return new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            backtrack(0,nums,new ArrayList<>(),res);
            return res;
        }

        private void backtrack(int i, int[] nums, List<Integer> list, List<List<Integer>> res){
            //先把传入的list添加到结果中，再往后遍历nums
            res.add(new ArrayList<>(list));
            for (int j  = i; j < nums.length; j++) {
                //代表nums中每种元素添加了的情况
                list.add(nums[j]);
                backtrack(j+1,nums,list,res);
                //代表nums中每种元素都没有添加的情况
                list.remove(list.size()-1);
            }
        }
    }
}
