package org.jiang.algorithms.dynamicprogramming.buyandsellstock;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStock3Test {

    int[] prices;
    int result;
    BestTimeToBuyAndSellStock3 btbss = new BestTimeToBuyAndSellStock3();

    @Test
    public void maxProfit() {
        prices = new int[]{3,3,5,0,0,3,1,4};
        result = btbss.maxProfit(prices);
        System.out.println(result);//6

        prices = new int[]{1,2,3,4,5};
        result = btbss.maxProfit(prices);
        System.out.println(result);//4

        prices = new int[]{7,6,4,3,1};
        result = btbss.maxProfit(prices);
        System.out.println(result);//0

        prices = new int[]{1};
        result = btbss.maxProfit(prices);
        System.out.println(result);//0
    }
}