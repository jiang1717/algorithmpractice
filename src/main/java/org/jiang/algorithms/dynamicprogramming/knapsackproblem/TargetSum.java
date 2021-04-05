package org.jiang.algorithms.dynamicprogramming.knapsackproblem;

/**
 * 494. 目标和
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例：
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *  
 *
 * 提示：
 *
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 *
 */

public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[][] dp = new int[nums.length][2001];
        dp[0][1000 + nums[0]] += 1;
        dp[0][1000 - nums[0]] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < 2001; j++) {
                if(j - nums[i] < 0 && j + nums[i] >= 2001){
                    continue;
                }
                if(j - nums[i] < 0){
                    dp[i][j] += dp[i-1][j+nums[i]];
                    continue;
                }
                if(j + nums[i] >= 2001){
                    dp[i][j] += dp[i-1][j-nums[i]];
                    continue;
                }
                dp[i][j] += dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]];
            }

        }

        return S > 1000? 0 : dp[nums.length-1][S+1000];
    }

}
