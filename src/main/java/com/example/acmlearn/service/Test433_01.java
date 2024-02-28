package com.example.acmlearn.service;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 433. 最小基因变化 第一遍 DFS
 */
public class Test433_01 {
    Integer step = -1;
    char[] letters = new char[]{'A','C','G','T'};
    HashMap<String, Integer> map = new HashMap<>();
    public int minMutation(String startGene, String endGene, String[] bank) {
        //思路
        //将bank放入Set中,将S中每个和E不一样的字母按顺序挨着替换成'A'、'C'、'G' 和 'T',当替换后的Tmp存在于Set中时，
        //记为一次成功的替换，step++,当Tmp==E时，return step;
        if (startGene == null || endGene == null || bank == null) {
            return -1;
        }
        HashSet<String> set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }
        dfs(startGene,endGene,set);
        return step;
    }

    int dfs (String S, String E, HashSet<String> set) {
        if (S == E) return step;
        for (int i = 0 ; i < S.length(); i++) {
            for (char c : letters) {
                if (c == S.charAt(i)) continue;
                String tmp = S.substring(0,i) + c + S.substring(i+1);
                if (set.contains(tmp) && !map.containsKey(tmp)) {
                    step = step == -1 ? 1 : ++step;
                    map.put(tmp,new Integer(step));
                    dfs(tmp,E,set);
                    break;
                }
            }
        }
        return step;
    }
}
