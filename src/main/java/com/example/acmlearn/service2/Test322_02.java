package com.example.acmlearn.service2;

import java.util.Arrays;

/**
 * 322. 零钱兑换——第二遍 动态规划
 */
public class Test322_02 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Test322_02 test322_02 = new Test322_02();
        System.out.println("test");
        System.out.println(test322_02.coinChange
                (new int[]{186,419,83,408}, 6249));
    }
}
