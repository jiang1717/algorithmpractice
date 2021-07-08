package org.jiang.algorithms.array.nsum;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FourSumTest {

    int[] nums;
    List<List<Integer>> res;
    FourSum fs = new FourSum();
    int target;

    @Test
    public void fourSum() {
        nums = new int[]{1,0,-1,0,-2,2};
        target = 0;
        res = fs.fourSum(nums, target);
        System.out.println(res);

        nums = new int[]{};
        target = 0;
        res = fs.fourSum(nums, target);
        System.out.println(res);
    }
}