package org.jiang.algorithms.dynamicprogramming.knapsackproblem;

/**
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 *
 * 分析：给一个可装载重量为 sum / 2 的背包和 N 个物品，每个物品的重量为 nums[i]。
 *      现在让你装物品，是否存在一种装法，能够恰好将背包装满？
 *
 */


public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }else{
            sum = sum / 2;
        }

        boolean[][] dp = new boolean[nums.length + 1][sum + 1];

        for (int j = 0; j <= sum; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if(dp[i-1][j]){
                    dp[i][j] = true;
                }else if(j-nums[i-1] >= 0 && dp[i-1][j-nums[i-1]]){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[nums.length][sum];

    }
}
