package com.example.acmlearn.service;

import org.springframework.util.ObjectUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidWindow239_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length - k + 1];
        // 维护队列从大到小顺序
        Deque<Integer> deque = new ArrayDeque<>();
        // 判断是否等于窗口， true 时 需要记录元素
        boolean flag = false;

        for (int i = 0; i < nums.length;i++){
            //获取当前值
            int curNum = nums[i];
            //离队
            while (!deque.isEmpty() && nums[deque.getLast()] <= curNum){
                deque.removeLast();
            }
            //入队 7 3 5 3 2 1
            deque.addLast(i);
            //如果i-队首==k移除队首
            if (i - deque.getFirst() == k) {
                deque.removeFirst();
            }
            //如果i到k了，开始记录
            if (!flag && i + 1  == k ) {
                flag = true;
            }
            //如果true，记录
            if (flag) {
                result[i + 1 - k] = nums[deque.getFirst()];
            }
        }

        return result;
    }
}
