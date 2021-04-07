package org.jiang.algorithms.dynamicprogramming.buyandsellstock;

import org.junit.Test;

public class BestTimeToBuyAndSellStock4Test {

    int[] prices;
    int result;
    int k;
    BestTimeToBuyAndSellStock4 btbss = new BestTimeToBuyAndSellStock4();

    @Test
    public void maxProfit() {
        prices = new int[]{2, 4, 1};
        k = 2;
        result = btbss.maxProfit(k, prices);
        System.out.println(result);//2

        prices = new int[]{3, 2, 6, 5, 0, 3};
        k = 2;
        result = btbss.maxProfit(k, prices);
        System.out.println(result);//7
    }
}