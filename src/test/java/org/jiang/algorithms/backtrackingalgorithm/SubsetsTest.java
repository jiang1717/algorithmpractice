package org.jiang.algorithms.backtrackingalgorithm;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SubsetsTest {

    int[] nums;
    List<List<Integer>> res;
    Subsets s = new Subsets();

    @Test
    public void subsets() {
        nums = new int[]{1, 2, 3};
        res = s.subsets(nums);
        System.out.println(res);

        nums = new int[]{0};
        res = s.subsets(nums);
        System.out.println(res);
    }
}