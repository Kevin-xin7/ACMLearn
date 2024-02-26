package com.example.acmlearn.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组 第一遍
 */
public class Test49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        String[] sortedStrs = new String[strs.length];
        //先排序
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            sortedStrs[i] = String.valueOf(charArray);
        }
        //再分组
        List<List<Integer>> indexLists = new ArrayList<>();
        HashMap<String,List<Integer>> strAndIndexMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = sortedStrs[i];
            if (strAndIndexMap.containsKey(s)) {
                List<Integer> indexList = strAndIndexMap.get(s);
                indexList.add(i);
            }else {
                strAndIndexMap.put(s, new ArrayList<>(Arrays.asList(i)));
            }
        }
        strAndIndexMap.forEach((k,v)->indexLists.add(v));
        //将分组后的结果放入result
        for (List<Integer> indexs : indexLists) {
            List<String> sList = new ArrayList<>();
            for (Integer index : indexs) {
                sList.add(strs[index]);
            }
            result.add(sList);
        }

        return result;
    }
}
