package com.example.acmlearn.service;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 433. 最小基因变化 第一遍 DFS
 */
public class Test433_03 {
    char[] letters = new char[]{'A','C','G','T'};
    HashMap<String, Integer> map = new HashMap<>();
    HashSet<String> set = new HashSet<>();
    public int minMutation(String startGene, String endGene, String[] bank) {
        //思路
        //将bank放入Set中,将S中每个和E不一样的字母按顺序挨着替换成'A'、'C'、'G' 和 'T',当替换后的Tmp存在于Set中时，
        //记为一次成功的替换，step++,当Tmp==E时，return step;
        if (startGene == null || endGene == null || bank == null) {
            return -1;
        }
        for (String s : bank) {
            set.add(s);
        }
        dfs(startGene,endGene);
        return map.get(endGene) == null ? -1 : map.get(endGene);
    }

    void dfs (String S, String E) {
        if (S == E) return ;
        int step = map.getOrDefault(S,0);
        char[] cs = S.toCharArray();
        for (int i = 0 ; i < S.length(); i++) {
            for (char letter : letters) {
                if (letter == cs[i]) continue;
                char[] clone = cs.clone();
                clone[i] = letter;
                String tmp = String.valueOf(clone);
                if (set.contains(tmp) && !map.containsKey(tmp)) {
                    map.put(tmp, step + 1);
                    dfs(tmp,E);
                }
            }
        }
    }

    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene=    "AACCGCTA";
        String[] bank = new String[3];
        bank[0] = "AACCGGTA";
        bank[1] = "AACCGCTA";
        bank[2] = "AAACGGTA";
        Test433_03 test433_03 = new Test433_03();
        int res = test433_03.minMutation(startGene, endGene, bank);
        System.out.println(res);
    }
}
