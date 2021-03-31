package org.jiang.algorithms.dynamicprogramming.subsequences;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumSubarrayTest {

    int[] nums;
    int result;
    MaximumSubarray ms = new MaximumSubarray();

    @Test
    public void maxSubArrayTest() {
        nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        result = ms.maxSubArray(nums);
        System.out.println(result);

        nums = new int[]{1};
        result = ms.maxSubArray(nums);
        System.out.println(result);

        nums = new int[]{0};
        result = ms.maxSubArray(nums);
        System.out.println(result);

        nums = new int[]{-1};
        result = ms.maxSubArray(nums);
        System.out.println(result);

        nums = new int[]{-10000};
        result = ms.maxSubArray(nums);
        System.out.println(result);

    }
}