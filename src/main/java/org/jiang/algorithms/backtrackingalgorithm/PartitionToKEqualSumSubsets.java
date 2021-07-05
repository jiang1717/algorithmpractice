package org.jiang.algorithms.backtrackingalgorithm;

/**
 * 698. 划分为k个相等的子集
 *
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 示例 1：
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 */
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        if(nums == null || k > nums.length){
            return false;
        }
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % k > 0){
            return false;
        }

        int target = sum / k;
        int[] bucket = new int[k];
        return backtrack(nums, target, bucket, 0);
    }

    public boolean backtrack(int[] nums, int target, int[] bucket, int n){
        if(n == nums.length){
            for (int i: bucket) {
                if(i != target){
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {
            if(bucket[i] + nums[n] > target){
                continue;
            }
            bucket[i] += nums[n];
            if (backtrack(nums, target, bucket, n+1)) {
                return true;
            }
            bucket[i] -= nums[n];
        }
        return false;
    }

    public boolean canPartitionKSubsets1(int[] nums, int k) {

        if(nums == null || k > nums.length){
            return false;
        }
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % k > 0){
            return false;
        }

        int target = sum / k;
        int[] bucket = new int[k];
        boolean[] used = new boolean[nums.length];
        return backtrack1(k, 0, nums, 0, target, used);
    }

    public boolean backtrack1(int k, int bucket, int[] nums, int start, int target, boolean[] used){
        if(k == 0){
            return true;
        }
        if(bucket == target){
            return backtrack1(k-1, 0, nums, 0, target, used);
        }

        for (int i = start; i < nums.length; i++) {

            if(used[i]){
                continue;
            }

            if(bucket + nums[i] > target){
                continue;
            }


            bucket += nums[i];
            used[i] = true;
            if(backtrack1(k, bucket, nums, i+1, target, used)){
                return true;
            }
            bucket -= nums[i];
            used[i] = false;
        }
        return false;
    }
}
