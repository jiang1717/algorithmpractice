package org.jiang.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestCoinChange {
    CoinChange c = new CoinChange();
    int[] coins1 = new int[]{1, 2, 5};
    int amount1 = 11;

    int[] coins2 = new int[]{2};
    int amount2 = 3;

    int[] coins3 = new int[]{1};
    int amount3 = 0;

    int[] coins4 = new int[]{1};
    int amount4 = 1;

    int[] coins5 = new int[]{1};
    int amount5 = 2;

    @Test
    public void testCoinChange1() {
        int n;

        n = c.coinChange1(coins1, amount1);//3
        System.out.println(n);

        n = c.coinChange1(coins2, amount2);//-1
        System.out.println(n);

        n = c.coinChange1(coins3, amount3);//0
        System.out.println(n);

        n = c.coinChange1(coins4, amount4);//1
        System.out.println(n);

        n = c.coinChange1(coins5, amount5);//2
        System.out.println(n);

    }

    @Test
    public void testCoinChange2() {
        int n;

        n = c.coinChange2(coins1, amount1);//3
        System.out.println(n);

        n = c.coinChange2(coins2, amount2);//-1
        System.out.println(n);

        n = c.coinChange2(coins3, amount3);//0
        System.out.println(n);

        n = c.coinChange2(coins4, amount4);//1
        System.out.println(n);

        n = c.coinChange2(coins5, amount5);//2
        System.out.println(n);
    }

    @Test
    public void testCoinChange3() {
        int n;

        n = c.coinChange2(coins1, amount1);//3
        System.out.println(n);

        n = c.coinChange2(coins2, amount2);//-1
        System.out.println(n);

        n = c.coinChange2(coins3, amount3);//0
        System.out.println(n);

        n = c.coinChange2(coins4, amount4);//1
        System.out.println(n);

        n = c.coinChange2(coins5, amount5);//2
        System.out.println(n);
    }
}