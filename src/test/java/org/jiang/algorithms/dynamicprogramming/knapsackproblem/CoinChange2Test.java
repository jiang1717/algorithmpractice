package org.jiang.algorithms.dynamicprogramming.knapsackproblem;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinChange2Test {

    int[] coins;
    int amount;
    int result;
    CoinChange2 cc2 = new CoinChange2();

    @Test
    public void change() {
        coins = new int[]{1, 2, 5};
        amount = 5;
        result = cc2.change(amount, coins);
        System.out.println(result);

        coins = new int[]{2};
        amount = 3;
        result = cc2.change(amount, coins);
        System.out.println(result);

        coins = new int[]{10};
        amount = 10;
        result = cc2.change(amount, coins);
        System.out.println(result);

    }
}