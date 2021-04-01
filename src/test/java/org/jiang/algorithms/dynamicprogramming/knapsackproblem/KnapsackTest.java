package org.jiang.algorithms.dynamicprogramming.knapsackproblem;

import org.junit.Test;

import static org.junit.Assert.*;

public class KnapsackTest {

    int n, w;
    int[] wt, val;
    int result;
    Knapsack k = new Knapsack();

    @Test
    public void testKnapsack() {
        n = 3;
        w = 4;
        wt = new int[]{2, 1, 3};
        val = new int[]{4, 2, 3};

        result = k.knapsack(n, w, wt, val);
        System.out.println(result);
    }
}