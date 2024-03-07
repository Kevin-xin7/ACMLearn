package com.example.acmlearn.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 78、子集
 * 分治法
 */
public class Test78_01 {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            if(nums.length==0) return new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            dfs(0,nums,new ArrayList<>(),res);
            return res;
        }

        public void dfs(int index,int[] nums,List<Integer> list,List<List<Integer>> res){
            if(index==nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }
            //不添加
            dfs(index+1,nums,list,res);
            //添加
            list.add(nums[index]);
            dfs(index+1,nums,list,res);
            //回溯
            list.remove(list.size()-1);
        }
    }
}
