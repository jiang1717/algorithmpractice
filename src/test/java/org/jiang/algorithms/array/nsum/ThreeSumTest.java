package org.jiang.algorithms.array.nsum;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ThreeSumTest {

    int[] nums;
    List<List<Integer>> res;
    ThreeSum ts = new ThreeSum();

    @Test
    public void threeSum() {
        nums = new int[]{-1,0,1,2,-1,-4};
        res = ts.threeSum(nums);
        System.out.println(res);

        nums = new int[]{0};
        res = ts.threeSum(nums);
        System.out.println(res);

        nums = new int[]{};
        res = ts.threeSum(nums);
        System.out.println(res);

    }
}