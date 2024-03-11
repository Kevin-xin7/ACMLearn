package com.example.acmlearn.service2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 322. 零钱兑换
 */
public class Test322_01 {
    int res = 0;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        //贪心算法DFS
        //将硬币降序排序
        Integer[] coinObjects = IntStream.of(coins).boxed().toArray(Integer[]::new);
        // 使用 Collections.reverseOrder() 创建一个降序比较器
        Arrays.sort(coinObjects, Collections.reverseOrder());
        // 再次转换回 int 数组
        int[] sortedCoins = Arrays.stream(coinObjects)
                .mapToInt(Integer::intValue)
                .toArray();
        dfs(sortedCoins, amount, 0);
        //如果最后没减到0，则返回-1
        return res == 0 ? -1 : res;
    }

    private void dfs(int[] coins, int amount, int count) {
        if (amount < 0) return;
        //已经找到最优解了
        if (res != 0) return;
        if (amount == 0) {
            res = count;
            return;
        }
        for (int coin : coins) {
            if (amount - coin >= 0) {
                dfs(coins, amount - coin, count + 1);
            }
        }
    }

//    private int dfs2(int[] coins) {
//        if (amount == 0) return 0;
//        for (int coin : coins) {
//            if (amount - coin >= 0) {
//                int n = amount / coin;
//                amount -= n * coin;
//                count += n;
//            }
//        }
//        return amount == 0 ? count : -1;
//    }

    public static void main(String[] args) {
        Test322_01 test322_01 = new Test322_01();
        System.out.println(test322_01.coinChange
                (new int[]{186,419,83,408}, 6249));
    }
}
