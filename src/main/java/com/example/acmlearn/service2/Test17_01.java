package com.example.acmlearn.service2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 *  分治法:两种思路，
 *  1：子问题为从每个数字的value中拿一个，把剩余的value传给下一层
 *  2：子问题为从每个数字的value中拿一个，把拿到的字符串传给下一层
 */
public class Test17_01 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        HashMap<String,String> map = new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        StringBuilder  value = new StringBuilder();
        dfs(digits,map,res,value);
        return res;
    }

    private void dfs(String digits, HashMap<String, String> map, List<String> res, StringBuilder value) {
        if (value.length() == digits.length()) {
            res.add(value.toString());
            return;
        }
        String s = map.get(digits.substring(value.length(), value.length() + 1));
        for (int i = 0; i < s.length(); i++) {
            value.append(s.charAt(i));
            dfs(digits, map, res, value);
            value.deleteCharAt(value.length() - 1);
        }
    }
}
