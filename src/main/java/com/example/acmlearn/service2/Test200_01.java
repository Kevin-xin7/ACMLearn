package com.example.acmlearn.service2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 200. 岛屿数量——自己想的BFS 太复杂了，没完成
 * BFS
 * 终止条件
 * 1、size-- <=0
 * 岛屿判断条件
 * BFS遍历情况：先将grid[0]入队，每层遍历出队一个节点，并将下一层入队，两层对照判断是否为岛屿
 * 遍历每层时，只判断每层有几个分离的1，连着的只记录开始和结尾,只判断上和左右
 * 判断岛屿只看当前层和下一层，当前层判断有几个分隔的岛屿，这个在当前层入队时，就判断好，因为它要看上一层
 * 岛屿的左右边界的左右为0，且它们的下一层也为0，岛屿数量+1
 * 所以每次循环需要做到操作有
 * 1、先看当前分隔段和下一层能否形成岛屿，能的话count+=1
 * 2、再看下一层有几段，如果下一层的分隔点0的上一层也就是当前层为1，则分割点无效，看下一分隔点0
 */
public class Test200_01 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        ArrayDeque<char[]> queue = new ArrayDeque<>();
        //分隔点的list
        List<List<Character>> difList = new ArrayList<>();
        char[] firstLevel =  grid[0];
        //判断第一层有几个分隔的岛屿
        //遍历第一层，找到分隔点，将分隔点加入分隔点list
        for (int i = 0; i < firstLevel.length; i++) {
            if (firstLevel[i] == '1' ){
                //前一个为0则新增分隔段
                if(i-1 >= 0 && firstLevel[i-1] == '0') {
                    difList.add(Arrays.asList('1'));
                }else{
                    if(difList.size() > 0) {
                        //取分隔点list最后一个分隔段，添加当前分隔点
                        difList.get(difList.size() - 1).add(firstLevel[i]);
                    }else {
                        //没有分隔段则新增一个分隔段
                        difList.add(Arrays.asList('1'));
                    }
                }
            }
        }
        int level = 0;
        queue.offer(grid[level]);
        while (!queue.isEmpty()) {
            //每次循环只有一层，不用size约束
            char[] cur = queue.poll();
            char[] next = grid[++level];
            queue.offer(next);
            int curIndex = 0;
            for (int i = 0; i < difList.size(); i++) {
                List<Character> list = difList.get(i);

            }
            while (curIndex < cur.length) {
                if (cur[curIndex] == '1') {
                    if (curIndex == 0 || cur[curIndex - 1] == '0') {
                        if (curIndex + 1 == cur.length || cur[curIndex + 1] == '0') {
                            count++;
                        }
                    }
                }
            }

        }
        return count;
    }
}
