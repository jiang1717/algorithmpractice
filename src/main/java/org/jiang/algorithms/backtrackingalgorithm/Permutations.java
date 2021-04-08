package org.jiang.algorithms.backtrackingalgorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 *
 */

public class Permutations {
    List<List<Integer>> list = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {

        if(nums == null || nums.length == 0){
            return null;
        }
        List<Integer> result = new LinkedList<>();
        backtrack(nums, result);
        return list;
    }

    public void backtrack(int[] nums, List<Integer> result){
        if(result.size() == nums.length){
            list.add(new LinkedList(result));
        }
        for (int i = 0; i < nums.length; i++) {
            if(result.contains(nums[i])){
                continue;
            }
            result.add(nums[i]);
            backtrack(nums, result);
            result.remove(result.size()-1);
        }
    }
}
