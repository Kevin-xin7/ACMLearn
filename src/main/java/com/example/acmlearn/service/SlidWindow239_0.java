package com.example.acmlearn.service;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidWindow239_0 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length - k + 1];
        // 维护队列从大到小顺序
        Deque<Integer> deque = new ArrayDeque<>();
        // 判断是否等于窗口， true 时 需要记录元素
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            // 当前遍历元素值
            int curNum = nums[i];
            // 出队
            while (!deque.isEmpty() && nums[deque.getLast()] <= curNum) {
                deque.removeLast();
            }
            // 入队
            deque.addLast(i);
            // 等于窗口 k 时，移除队首 0123
            if (i - deque.getFirst() == k) {
                deque.removeFirst();
            }
            // 等于窗口k,就需要记录窗口内最大元素了
            if (!flag && i == k - 1) {
                flag = true;
            }
            // 记录答案
            if (flag) {
                result[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return result;
    }
}
