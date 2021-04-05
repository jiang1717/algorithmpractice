package org.jiang.algorithms.dynamicprogramming.knapsackproblem;

import org.junit.Test;

import static org.junit.Assert.*;

public class OnesAndZeroesTest {

    String[] strs;
    int m;
    int n;
    int result;
    OnesAndZeroes oaz = new OnesAndZeroes();

    @Test
    public void findMaxForm() {
        strs = new String[]{"10", "0001", "111001", "1", "0"};
        m = 5;
        n = 3;
        result = oaz.findMaxForm(strs, m, n);
        System.out.println(result);

        strs = new String[]{"10", "0", "1"};
        m = 1;
        n = 1;
        result = oaz.findMaxForm(strs, m, n);
        System.out.println(result);

    }
}