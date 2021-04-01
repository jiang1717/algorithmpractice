package org.jiang.algorithms.dynamicprogramming.knapsackproblem;

/**
 * 今天就来说一下背包问题吧，就讨论最常说的 0-1 背包问题，简单描述一下吧：
 *
 * 给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。其中第i个物品的重量为wt[i]，价值为val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 *
 * 举个简单的例子，输入如下：
 *
 * N = 3, W = 4
 * wt = [2, 1, 3]
 * val = [4, 2, 3]
 * 算法返回 6，选择前两件物品装进背包，总重量 3 小于W，可以获得最大价值 6。
 *
 * 链接：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485064&idx=1&sn=550705eb67f5e71487c8b218382919d6&chksm=9bd7f880aca071962a5a17d0f85d979d6f0c5a5ce32c84b8fee88e36d451f9ccb3bb47b88f78&scene=21
 *
 */

public class Knapsack {
    public int knapsack(int n, int w, int[] wt, int[] val) {
        if(n == 0 || wt == null || wt.length == 0 || val == null || val.length == 0 || w == 0){
            return 0;
        }
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < w + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if(j - wt[i - 1] < 0){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[n][w];
    }
}
