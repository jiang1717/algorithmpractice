package org.jiang.algorithms.dynamicprogramming.knapsackproblem;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionEqualSubsetSumTest {

    int[] nums;
    boolean result;
    PartitionEqualSubsetSum pess = new PartitionEqualSubsetSum();

    @Test
    public void canPartition() {
        nums = new int[]{1, 5, 11, 5};
        result = pess.canPartition(nums);
        System.out.println(result);

        nums = new int[]{1, 2, 3, 5};
        result = pess.canPartition(nums);
        System.out.println(result);

        nums = new int[]{1, 1};
        result = pess.canPartition(nums);
        System.out.println(result);
    }
}