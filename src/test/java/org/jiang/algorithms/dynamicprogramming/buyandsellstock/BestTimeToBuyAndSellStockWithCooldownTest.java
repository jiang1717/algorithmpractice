package org.jiang.algorithms.dynamicprogramming.buyandsellstock;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStockWithCooldownTest {

    int[] prices;
    int result;
    BestTimeToBuyAndSellStockWithCooldown btbss = new BestTimeToBuyAndSellStockWithCooldown();

    @Test
    public void maxProfit() {
        prices = new int[]{1,2,3,0,2};
        result = btbss.maxProfit(prices);
        System.out.println(result);//3
    }
}