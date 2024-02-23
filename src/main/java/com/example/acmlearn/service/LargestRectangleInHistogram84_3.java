package com.example.acmlearn.service;

public class LargestRectangleInHistogram84_3 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = -1;
        right[len - 1] = len;
        int res = 0;
        //左右各遍历一遍，记录每个坐标的左右边界
        for (int i = 1; i < len; i++) {
            int index = i - 1;
            while (index >= 0 && heights[index] >= heights[i]) {
                index = left[index];
            }
            left[i] = index;
        }
        for (int i = len - 2; i >= 0; i--) {
            int index = i + 1;
            while (index < len && heights[index] >= heights[i]) {
                index = right[index];
            }
            right[i] = index;
        }
        for (int i = 0; i < len; i++) {
            res = Math.max((right[i] - left[i] - 1) * heights[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
//        int[] heights = {1, 1};
        LargestRectangleInHistogram84_3 solution = new LargestRectangleInHistogram84_3();
        int res = solution.largestRectangleArea(heights);
        System.out.println(res);
    }
}
