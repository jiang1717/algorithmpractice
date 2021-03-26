package org.jiang.algorithms.dynamicprogramming.subsequences;

import org.junit.Test;

import static org.junit.Assert.*;

public class RussianDollEnvelopesTest {

    public RussianDollEnvelopes rde = new RussianDollEnvelopes();
    int[] nums;
    int[][] envelopes;

    @Test
    public void testLengthOfLIS() {
        nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int result = rde.lengthOfLIS(nums);
        System.out.println(result);
    }

    @Test
    public void testMaxEnvelopes() {
        envelopes = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int result = rde.maxEnvelopes(envelopes);
        System.out.println(result);

        envelopes = new int[][]{{1, 1}, {1, 1}, {1, 1}};
        result = rde.maxEnvelopes(envelopes);
        System.out.println(result);
    }
}