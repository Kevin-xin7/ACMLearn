package com.example.acmlearn.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组 数组计数法
 */
public class Test49_05 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            //有两种方法，排序法和数组计数法,以下是数组计数法
            List<List<String>> result = new ArrayList<>();
            HashMap<String,List<String>> valuemap = new HashMap<>();

            for (String s : strs) {
                int[] countArray = new int[26];
                for (char c : s.toCharArray()) {
                    countArray[c - 'a'] ++;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < countArray.length; i ++) {
                    if (countArray[i] != 0) {
                        sb.append(i + 'a');
                        sb.append(countArray[i]);
                    }
                }
                List<String> values = valuemap.getOrDefault(sb.toString(), new ArrayList<>());
                values.add(s);
                valuemap.put(sb.toString(), values);
            }
            result.addAll(valuemap.values());
            return result;
        }
    }
}
