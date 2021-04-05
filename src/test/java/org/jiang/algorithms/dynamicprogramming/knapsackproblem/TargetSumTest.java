package org.jiang.algorithms.dynamicprogramming.knapsackproblem;

import org.junit.Test;

import static org.junit.Assert.*;

public class TargetSumTest {
    int[] nums;
    int S;
    int result;
    TargetSum ts = new TargetSum();

    @Test
    public void findTargetSumWays() {
        nums = new int[]{1, 1, 1, 1, 1};
        S = 3;
        result = ts.findTargetSumWays(nums, S);
        System.out.println(result);

        nums = new int[]{1, 0};
        S = 1;
        result = ts.findTargetSumWays(nums, S);
        System.out.println(result);

        nums = new int[]{1, 2, 7, 9, 981};
        S = 1000000000;
        result = ts.findTargetSumWays(nums, S);
        System.out.println(result);

        nums = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1};
        S = 1;
        result = ts.findTargetSumWays(nums, S);
        System.out.println(result);

        nums = new int[]{1, 2, 1};
        S = 0;
        result = ts.findTargetSumWays(nums, S);
        System.out.println(result);
    }
}