package org.jiang.algorithms.backtrackingalgorithm;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CombinationsTest {

    int n;
    int k;
    List<List<Integer>> res;
    Combinations c = new Combinations();

    @Test
    public void combine() {
        n = 4;
        k = 2;
        res = c.combine(n, k);
        System.out.println(res);
    }
}