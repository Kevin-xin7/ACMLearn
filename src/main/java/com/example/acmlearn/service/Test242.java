package com.example.acmlearn.service;

import java.lang.reflect.Array;

/**
 * 242. 有效的字母异位词
 */
public class Test242 {
    public boolean isAnagram(String s, String t) {
        //1、暴力求解，先转成char数组，用Arrays.sort 再equals比较
        //2、new 两个int[26]数组，先把2s的全装进去，再把t的全装进去，最后比较两个数组是否相等
        if (s.length() != t.length()) return false;

        char[] sC = s.toCharArray();
        char[] tC = t.toCharArray();
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        for(char  c : sC) {
            sCount[c-'a']++;
        }
        for (char c: tC) {
            tCount[c-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sCount[i] != tCount[i]) return false;
        }

        return true;
    }
}
