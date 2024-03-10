package com.example.acmlearn.service2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 51. N 皇后 —— 第二遍-简化自己第一遍的代码
 * 思路：寻找最小重复子问题，每行放一个可以确保一行中不会相互攻击，除此之外就只需要确保同一列不出现两个皇后
 * 终止条件：
 * 1、n个皇后都放进去了
 * 2、同一列没有其他皇后
 * 3、不处于其他皇后的斜线上
 */
public class Test51_02 {
    List<List<Integer>> middle = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> lowList = new ArrayList<>();
        List<Integer> upList = new ArrayList<>();
        dfs(list, n, 0, lowList, upList);
        //添加的时候是从下到上的，输出要求从上到下，所以先倒序
        Collections.reverse(middle);
        for (List<Integer> indexs : middle) {
            List<String> row = new ArrayList<>();
            for (int index : indexs) {
                StringBuilder target = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (i == index) {
                        target.append("Q");
                    } else {
                        target.append(".");
                    }
                }
                row.add(target.toString());
            }
            res.add(row);
        }
        return res;
    }

    private void dfs(List<Integer> list, int n, int y, List<Integer> lowList, List<Integer> upList) {
        if (list.size() == n) {
            middle.add(new ArrayList<>(list));
            return;
        }
        for (int x = 0; x < n; x++) {
            if (list.contains(x)) continue;
            if(lowList.contains(x-y)) continue;
            if(upList.contains(x+y)) continue;
            lowList.add(x-y);
            upList.add(x+y);
            list.add(x);
            y++;
            dfs(list, n, y, lowList, upList);
            y--;
            lowList.remove(lowList.size()-1);
            upList.remove(upList.size()-1);
            list.remove(list.size()-1);
        }
    }

    //检查同一斜线是否有皇后，有则返回false，没有就将当前位置的斜线位置添加到map中
    private boolean check(int x, int y, int n, List<Integer> lowList, List<Integer> upList, HashMap<Integer, List<Integer>> map) {
        //4 + 1 = 5, 3 + 2 = 5, 2 + 3 = 5, 1 + 4 = 5 左上到右下
        //2 + -1 = 1, 3 + -2 = 1, 4 + -3 = 1; 左下到右上
        //第x行y列，如果某行某列的x+y或x-y和某个位置的值相同，则说明它们在同一斜线上
        //y = x + count1和y = -x + count2分别代表两条斜线，key分别为1,-1放到map中
        int count1 = x - y;
        int count2 = x + y;

        //从左下出发到右上斜率为1的斜线
        if (lowList.contains(count1)) return false;
        //从左上出发到右下斜率为-1的斜线
        if (upList.contains(count2)) return false;
        //当前位置不处于任何一条斜线，则添加当前位置所处斜线进map
        lowList.add(count1);
        upList.add(count2);

        return true;
    }

    //撤销添加斜线操作
    private HashMap<Integer, List<Integer>> revert(int x, int y, HashMap<Integer, List<Integer>> map) {
        int count1 = x - y;
        int count2 = x + y;
        //从左下出发到右上斜率为1的斜线
        List<Integer> lowList = map.getOrDefault(1, new ArrayList<>());
        //从左上出发到右下斜率为-1的斜线
        List<Integer> upList = map.getOrDefault(-1, new ArrayList<>());
        //当前位置不处于任何一条斜线，则添加当前位置所处斜线进map
        lowList.remove(lowList.size()-1);
        upList.remove(upList.size()-1);
        map.put(1,lowList);
        map.put(-1,upList);
        return map;
    }
}
