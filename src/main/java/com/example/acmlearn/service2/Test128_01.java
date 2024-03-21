package com.example.acmlearn.service2;

import java.util.Arrays;

/**
 * 128. 最长连续序列 ——第一遍 通过
 * 先排序再遍历
 */
public class Test128_01 {
    public int longestConsecutive(int[] nums) {
        int maxLong = 0;
        Arrays.sort(nums);
        int left = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length;i++) {
            if(nums[i] == left) continue;
            if (nums[i] == left + 1) {
                count++;
            }else {
                maxLong = Math.max(maxLong, count);
                count = 1;
            }
            left = nums[i];
        }
        maxLong = Math.max(maxLong, count);
        return maxLong;
    }

    public static void main(String[] args) {
        //[0,3,7,2,5,8,4,6,0,1]
        Test128_01 t = new Test128_01();
//        System.out.println(t.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(t.longestConsecutive(new int[]{1,2,0,1}));
    }
}
