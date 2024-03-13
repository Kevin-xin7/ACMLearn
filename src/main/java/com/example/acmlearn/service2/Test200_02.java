package com.example.acmlearn.service2;

import org.springframework.stereotype.Controller;

public class Test200_02 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(r, c, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int r, int  c, char[][] grid){
        if(r < 0 || c < 0 || r > grid.length -1 || c > grid[0].length -1 || grid[r][c] != '1') return;
        //淹没陆地，为了区分原本的海洋,标记为2
        grid[r][c] = 2;

        dfs(r, c + 1, grid);
        dfs(r, c - 1, grid);
        dfs(r - 1, c, grid);
        dfs(r + 1, c, grid);
    }
}
