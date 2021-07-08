package org.jiang.algorithms.array.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 */

public class ThreeSum {

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

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tuples = twoSum(nums, i + 1, 0 - nums[i]);
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
