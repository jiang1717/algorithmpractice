package org.jiang.algorithms.array.binarysearch;

import java.util.Arrays;
import java.util.Collections;

/**
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，
 * 她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 * 示例 1：
 *
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 *
 * 示例 2：
 *
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 *
 * 示例 3：
 *
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 *
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        //二分搜索，k最小值为1，最大值为max(piles)，对每一个k计算所需要的时间
        //k会存在一个区间满足时间等于h，取最小的k，也就是左边界
        int left = 1;
        int right = max(piles);
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(getTime(piles, mid) > h){
                left = mid + 1;
            }else if (getTime(piles, mid) < h){
                right = mid - 1;
            }else if (getTime(piles, mid) == h){
                right = mid - 1;
            }
        }

        return left;
    }

    public int getTime(int[] piles, int k){
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += piles[i] / k + (piles[i] % k > 0 ? 1 : 0);
        }
        return time;
    }

    public int max(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
