package org.jiang.algorithms.array.prefixsum;

import java.util.HashMap;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 */

public class SubarraySumQqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSum= new HashMap<>(nums.length + 1);
        preSum.put(0,1);

        int res = 0;
        int sum0_i = 0;
        for (int i = 0; i < nums.length; i++) {
            sum0_i += nums[i];
            int sum0_j = sum0_i - k;
            if(preSum.containsKey(sum0_j)){
                res += preSum.get(sum0_j);
            }
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return res;
    }
}
