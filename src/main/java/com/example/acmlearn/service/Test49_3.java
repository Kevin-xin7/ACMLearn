package com.example.acmlearn.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 * 按照0ms的写法完善
 */
public class Test49_3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        //先排序
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedStr = String.valueOf(charArray);
            List<String> stringList = map.getOrDefault(sortedStr, new ArrayList<>());
            stringList.add(strs[i]);
            map.put(sortedStr, stringList);
        }
        result.addAll(map.values());
        return result;
    }
}
