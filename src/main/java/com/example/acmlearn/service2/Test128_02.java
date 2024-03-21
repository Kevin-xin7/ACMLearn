package com.example.acmlearn.service2;

import java.util.HashSet;
import java.util.Set;

/**
 *  128. 最长连续序列
 *
 */
public class Test128_02 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;

        for (int num : set) {
            int cur = num;
            if (!set.contains(num-1)) {
                while (set.contains(cur + 1)) cur++;
            }
            res = Math.max(res, cur - num + 1);
        }

        return res;
    }
}
