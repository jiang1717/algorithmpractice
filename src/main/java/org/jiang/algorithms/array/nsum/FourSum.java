package org.jiang.algorithms.array.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：答案中不可以包含重复的四元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [], target = 0
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 */

public class FourSum {
    public List<List<Integer>> twoSum(int[] nums, int start, int target){
        List<List<Integer>> res = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;
        while(left < right){
            int sum = nums[left] + nums[right];
            int l = nums[left];
            int r = nums[right];
            if(sum == target){
                res.add(new ArrayList<>());
                res.get(res.size() - 1).add(nums[left]);
                res.get(res.size() - 1).add(nums[right]);
                while(left < right && nums[left] == l){
                    left++;
                }
                while(left < right && nums[right] == r){
                    right--;
                }

            }else if(sum > target){
                while(left < right && nums[right] == r){
                    right--;
                }
            }else{
                while(left < right && nums[left] == l){
                    left++;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i < nums.length; i++) {
            List<List<Integer>> tuples = twoSum(nums, i + 1, target - nums[i]);
            for(List<Integer> t : tuples){
                t.add(nums[i]);
                res.add(new ArrayList<>(t));
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]){
                i++;
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tuples = threeSum(nums, i + 1, target - nums[i]);
            for(List<Integer> t : tuples){
                t.add(nums[i]);
                res.add(new ArrayList<>(t));
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]){
                i++;
            }
        }
        return res;
    }
}
