package org.jiang.algorithms.dynamicprogramming.buyandsellstock;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStock2Test {

    int[] prices;
    int result;
    BestTimeToBuyAndSellStock2 btbss = new BestTimeToBuyAndSellStock2();

    @Test
    public void maxProfit() {
        prices = new int[]{7, 1, 5, 3, 6, 4};
        result = btbss.maxProfit(prices);
        System.out.println(result);//7

        prices = new int[]{1, 2, 3, 4, 5};
        result = btbss.maxProfit(prices);
        System.out.println(result);//4

        prices = new int[]{7, 6, 4, 3, 1};
        result = btbss.maxProfit(prices);
        System.out.println(result);//0
    }
}