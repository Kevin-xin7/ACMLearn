package com.example.acmlearn.service2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 322. 零钱兑换——第一遍 记忆化搜索
 */
public class Test322_01 {
     int[] memo;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        memo = new int[amount + 1];
        dp(coins, amount);
        //如果最后没减到0，则返回-1
        return memo[amount] == 0 ? -1 : memo[amount];
    }

    private int dp(int[] coins, int amount) {
        //base case termination
        if (amount < 0) return -1;
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != 0) return memo[amount];
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = dp(coins, amount - coin);
            if (count < 0) continue;
            res = Math.min(res,memo[amount - coin] + 1);
        }
        memo[amount] =  res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }

    public static void main(String[] args) {
        Test322_01 test322_01 = new Test322_01();
        System.out.println(test322_01.coinChange
                (new int[]{186,419,83,408}, 6249));
    }
}
