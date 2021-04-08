package org.jiang.algorithms.backtrackingalgorithm;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PermutationsTest {

    int[] nums;
    List<List<Integer>> result;

    Permutations p = new Permutations();

    @Test
    public void permute() {
        nums = new int[]{1, 2, 3};
        result = p.permute(nums);
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}