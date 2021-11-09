package org.jiang.algorithms.interviewquestion;

import java.util.*;

/**
 * 659. 分割数组为连续子序列
 *
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个
 * 长度至少为 3 的子序列，其中每个子序列都由连续整数组成。
 *
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 * 示例 1：
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 * 示例 2：
 *
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * 示例 3：
 *
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
 */

public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        //设置两个map，分别表示nums中元素的剩余个数frep，以及对元素的需求need
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> need = new HashMap<>();
        //记录了每个元素的初始个数
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            //如果当前元素已经不够了，直接跳过
            if(!(freq.containsKey(nums[i]) && freq.get(nums[i]) > 0)){
                continue;
            }

            if(need.containsKey(nums[i]) && need.get(nums[i]) > 0){
                // 情况一：nums[i] 可以加入到已经存在的队列中，即need[nums[i]] > 0
                freq.put(nums[i], freq.get(nums[i]) - 1);
                need.put(nums[i], need.get(nums[i]) - 1);
                need.put(nums[i] + 1, need.getOrDefault(nums[i] + 1, 0) + 1);
            }else if((freq.containsKey(nums[i]) && freq.get(nums[i]) > 0) &&
                    (freq.containsKey(nums[i] + 1) && freq.get(nums[i] + 1) > 0) &&
                    (freq.containsKey(nums[i] + 2) && freq.get(nums[i] + 2) > 0)){
                // 情况二：nums[i]可以作为新序列的第一个元素，
                // 即need[nums[i]], need[nums[i]+1], need[nums[i]+2]都存在且大于零
                freq.put(nums[i], freq.get(nums[i]) - 1);
                freq.put(nums[i] + 1, freq.get(nums[i] + 1) - 1);
                freq.put(nums[i] + 2, freq.get(nums[i] + 2) - 1);

                need.put(nums[i] + 3, need.getOrDefault(nums[i] + 3, 0) + 1);
            }else{
                // 不符合上述两种情况，返回false
                return false;
            }
        }
        return true;
    }

    // 打印符合要求的序列
    public Map<Integer, List<List<Integer>>> needSeq = new HashMap<>();
    public boolean isPossible2(int[] nums) {
        //设置两个map，分别表示nums中元素的剩余个数frep，以及对元素的需求need
        HashMap<Integer, Integer> freq = new HashMap<>();
        needSeq.clear();
        //记录了每个元素的初始个数
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            //如果当前元素已经不够了，直接跳过
            if(!(freq.containsKey(nums[i]) && freq.get(nums[i]) > 0)){
                continue;
            }

            if(needSeq.containsKey(nums[i]) && needSeq.get(nums[i]).size() > 0){
                // 情况一：nums[i] 可以加入到已经存在的队列中，即need[nums[i]] > 0
                freq.put(nums[i], freq.get(nums[i]) - 1);

                List<Integer> remove = needSeq.get(nums[i]).remove(0);
                remove.add(nums[i]);
                if(!needSeq.containsKey(nums[i] + 1)){
                    needSeq.put(nums[i] + 1, new ArrayList<>());
                }
                needSeq.get(nums[i] + 1).add(remove);
            }else if((freq.containsKey(nums[i]) && freq.get(nums[i]) > 0) &&
                    (freq.containsKey(nums[i] + 1) && freq.get(nums[i] + 1) > 0) &&
                    (freq.containsKey(nums[i] + 2) && freq.get(nums[i] + 2) > 0)){
                // 情况二：nums[i]可以作为新序列的第一个元素，
                // 即need[nums[i]], need[nums[i]+1], need[nums[i]+2]都存在且大于零
                freq.put(nums[i], freq.get(nums[i]) - 1);
                freq.put(nums[i] + 1, freq.get(nums[i] + 1) - 1);
                freq.put(nums[i] + 2, freq.get(nums[i] + 2) - 1);

                if(!needSeq.containsKey(nums[i] + 3)){
                    needSeq.put(nums[i] + 3, new ArrayList<>());
                }

                List<Integer> newSeq = new ArrayList<>();
                newSeq.add(nums[i]);
                newSeq.add(nums[i] + 1);
                newSeq.add(nums[i] + 2);
                needSeq.get(nums[i] + 3).add(newSeq);
            }else{
                // 不符合上述两种情况，返回false
                return false;
            }
        }
        return true;
    }

    public void printSeq(int[] arr){
        if(isPossible2(arr)){
            for(List<List<Integer>> lists : needSeq.values()){
                for(List<Integer> list : lists){
                    for(Integer num : list){
                        System.out.print(num + " ");
                    }
                    System.out.println();
                }
            }
        }else{
            System.out.println("False");
        }
    }

    public static void main(String[] args) {
        SplitArrayIntoConsecutiveSubsequences saics = new SplitArrayIntoConsecutiveSubsequences();
        System.out.println(saics.isPossible(new int[]{1,2,3,3,4,4,5,5})); // true
        System.out.println(saics.isPossible(new int[]{1,2,3,4,4,5})); // false

        saics.printSeq(new int[]{1,2,3,3,4,4,5,5});
        saics.printSeq(new int[]{1,2,3,4,4,5});
    }
}
