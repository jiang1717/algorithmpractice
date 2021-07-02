package org.jiang.algorithms.array.binarysearch;

/**
 * 410. 分割数组的最大值
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 *
 * 设计一个算法使得子这 m 个数组各自和的最大值最小。
 *
 * 示例 1：
 *
 * 输入：nums = [7,2,5,10,8], m = 2
 * 输出：18
 * 解释：
 * 一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4,5], m = 2
 * 输出：9
 * 示例 3：
 *
 * 输入：nums = [1,4,4], m = 3
 * 输出：4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-largest-sum
 */

/**
 * 我们可以反过来，限制一个最大子数组和 max，来反推最大子数组和为 max 时，至少可以将 nums 分割成几个子数组。
 * 在每个子数组和不超过 max 的条件下，计算 nums 至少可以分割成几个子数组
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        //遍历从mmin到mmax的所有max值，计算至少能分成n组，若n等于m，则一定能分成m组
        //split函数与max呈反相关，所以max若从小向大遍历，则n从大变小
        //存在多个max对应同一个n的情况，若二分搜索，则要用左边界
        int mmin = nums[0];
        int mmax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > mmin){
                mmin = nums[i];
            }
            mmax += nums[i];
        }
        while(mmin <= mmax){
            int mid = mmin + (mmax - mmin) / 2;
            int n = split(nums, mid);
            if(n == m){
                mmax = mid - 1;
            }else if(n > m){
                mmin = mid + 1;
            }else if(n < m){
                mmax = mid - 1;
            }
        }

        return mmin;
    }

    public int split(int[] nums, int max){

        //每组数的和的最大值为max，至少能分成多少组
        int sum = 0;
        // 至少可以分割的子数组数量
        int n = 1;
        for (int i = 0; i < nums.length; i++) {
            if(sum + nums[i] > max){
                n++;
                sum = nums[i];
            }else{
                sum += nums[i];
            }
        }

        return n;
    }
}
