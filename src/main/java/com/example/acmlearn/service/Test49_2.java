package com.example.acmlearn.service;

import java.util.*;
import java.util.AbstractList;
public class Test49_2 {

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            return new AbstractList<List<String>>() {
                private final List<List<String>> list = new ArrayList<>();

                @Override
                public List<String> get(int index) {
                    initList();
                    return list.get(index);
                }

                @Override
                public int size() {
                    initList();
                    return list.size();
                }

                void initList() {
                    if (list.isEmpty()) {
                        Map<String, List<String>> map = new HashMap();
                        for(String s : strs) {
                            char[] array = s.toCharArray();
                            Arrays.sort(array);
                            String key = new String(array);
                            List<String> stringList = map.getOrDefault(key, new ArrayList<String>());
                            stringList.add(s);
                            map.put(key, stringList);
                        }
                        list.addAll(map.values());
                    }
                }
            };
        }
    }
}
