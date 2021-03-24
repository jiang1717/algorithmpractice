package org.jiang.algorithms.dynamicprogramming;

import java.util.Arrays;

/**
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 *
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。
 * 如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 *
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 *
 */
public class SuperEggDrop {
    int[][] memo;
    public int superEggDrop1(int k, int n){
        memo = new int[k + 1][n + 1];
        return dp(k, n);
    }

    public int dp(int k, int n){
        if(n == 0){
            return 0;
        }else if(k == 1){
            return n;
        }
        if(memo[k][n] > 0){
            return memo[k][n];
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            result = Math.min(result, Math.max(dp(k-1, i-1), dp(k, n-i)) + 1);
        }
        memo[k][n] = result;
        return result;
    }
}
