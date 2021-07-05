package org.jiang.algorithms.backtrackingalgorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionToKEqualSumSubsetsTest {

    int[] nums;
    int k;
    boolean result;
    PartitionToKEqualSumSubsets ptkss = new PartitionToKEqualSumSubsets();

    @Test
    public void canPartitionKSubsets() {
        nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        k = 4;
        result = ptkss.canPartitionKSubsets(nums, k);
        System.out.println(result);
    }

    @Test
    public void canPartitionKSubsets1() {
        nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        k = 4;
        result = ptkss.canPartitionKSubsets1(nums, k);
        System.out.println(result);
    }
}