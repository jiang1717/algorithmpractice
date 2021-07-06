package org.jiang.algorithms.backtrackingalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 */

public class Subsets {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.clear();
        if(nums == null){
            return null;
        }

        List<Integer> track = new ArrayList<>();
        backtrack(nums, track, 0);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> track, int start){
        res.add(new ArrayList<>(track));
        if(start == nums.length){
            return;
        }
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, track, i+1);
            track.remove(track.size()-1);
        }
    }
}

