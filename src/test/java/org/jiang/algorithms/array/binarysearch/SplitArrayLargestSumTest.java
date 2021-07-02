package org.jiang.algorithms.array.binarysearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class SplitArrayLargestSumTest {

    int[] nums;
    int m;
    int result;

    SplitArrayLargestSum sals = new SplitArrayLargestSum();

    @Test
    public void testSplitArray() {
        nums = new int[]{7,2,5,10,8};
        m = 2;
        result = sals.splitArray(nums, m);
        System.out.println(result);//18

        nums = new int[]{1,2,3,4,5};
        m = 2;
        result = sals.splitArray(nums, m);
        System.out.println(result);//9

        nums = new int[]{1,4,4};
        m = 3;
        result = sals.splitArray(nums, m);
        System.out.println(result);//4

    }
}