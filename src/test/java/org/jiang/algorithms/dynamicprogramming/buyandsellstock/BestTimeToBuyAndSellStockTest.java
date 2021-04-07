package org.jiang.algorithms.dynamicprogramming.buyandsellstock;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStockTest {

    int[] prices;
    int result;
    BestTimeToBuyAndSellStock btbss = new BestTimeToBuyAndSellStock();

    @Test
    public void maxProfit() {
        prices = new int[]{7, 1, 5, 3, 6, 4};
        result = btbss.maxProfit(prices);
        System.out.println(result);//5

        prices = new int[]{7, 6, 4, 3, 1};
        result = btbss.maxProfit(prices);
        System.out.println(result);//0

    }
}