package org.jiang.algorithms.dynamicprogramming;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 *
 */

public class CoinChange {
    //暴力解法



    public int coinChange1(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }else if(amount < 0){
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for(int coin : coins){
            int sub = coinChange1(coins, amount - coin);
            if(sub < 0){
                continue;
            }
            result = Math.min(result, sub + 1);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    //自顶向下 memo数组
    int[] memo;
    public int coinChange2(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -2);

        return dp(coins, amount);
    }
    public int dp(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }else if(amount < 0){
            return -1;
        }
        if(memo[amount] > 0){
            return memo[amount];
        }
        int result = Integer.MAX_VALUE;
        for(int coin : coins){
            int sub = dp(coins, amount - coin);
            if(sub < 0){
                continue;
            }
            result = Math.min(result, sub + 1);
        }
        memo[amount] = result == Integer.MAX_VALUE ? -1 : result;
        return memo[amount];
    }

    //自底向上 dp数组

    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for(int coin : coins){
                if(i - coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
