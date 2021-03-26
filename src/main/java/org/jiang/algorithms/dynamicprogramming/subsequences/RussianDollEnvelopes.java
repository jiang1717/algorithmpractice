package org.jiang.algorithms.dynamicprogramming.subsequences;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 俄罗斯套娃信封问题
 *
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 *
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 注意：不允许旋转信封。
 *
 *  
 * 示例 1：
 *
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 示例 2：
 *
 * 输入：envelopes = [[1,1],[1,1],[1,1]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= envelopes.length <= 5000
 * envelopes[i].length == 2
 * 1 <= wi, hi <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 *
 */

public class RussianDollEnvelopes {

    //基础问题 最长递增子序列（LTS Longest Increasing Subsequence）
    //给定一个无序的整数数组，找到其中最长上升子序列的长度
    int[] dp;

    //复杂度：O(n^2)
    public int lengthOfLIS(int[] nums){
        int len = nums.length;
        dp = new int[len];
        Arrays.fill(dp, 1);
        for(int i = 0; i < len; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = 0;
        for (int length : dp) {
            if(length > result){
                result = length;
            }
        }
        return result;
    }



    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<>(){
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
                    }
                });
        int len = envelopes.length;
        int[] height = new int[len];
        for(int i = 0; i < len; i++){
            height[i] = envelopes[i][1];
        }
        int result = lengthOfLIS(height);
        return result;
    }
}
