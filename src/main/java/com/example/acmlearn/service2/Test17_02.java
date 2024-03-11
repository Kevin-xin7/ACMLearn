package com.example.acmlearn.service2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 *  分治法:两种思路，
 *  1：子问题为从每个数字的value中拿一个，把剩余的value传给下一层
 *  2：子问题为从每个数字的value中拿一个，把拿到的字符串传给下一层
 */
public class Test17_02 {
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
        dfs(digits,map,res,"");
        return res;
    }

    private void dfs(String digits, HashMap<String, String> map, List<String> res, String s) {
        if (s.length() == digits.length()) {
            res.add(s);
            return;
        }
        for(int i = 0; i < digits.length(); i++) {
            String value = map.get(digits.substring(i,i+1));
            for(int j = 0; j < value.length(); j++) {
                dfs(digits, map, res, s + value.charAt(j));
            }
        }
    }
}
