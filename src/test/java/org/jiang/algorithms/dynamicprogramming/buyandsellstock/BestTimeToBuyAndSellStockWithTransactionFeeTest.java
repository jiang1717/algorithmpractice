package org.jiang.algorithms.dynamicprogramming.buyandsellstock;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStockWithTransactionFeeTest {

    int[] prices;
    int fee;
    int result;
    BestTimeToBuyAndSellStockWithTransactionFee btbss = new BestTimeToBuyAndSellStockWithTransactionFee();

    @Test
    public void maxProfit() {
        prices = new int[]{1, 3, 2, 8, 4, 9};
        fee = 2;
        result = btbss.maxProfit(prices, fee);
        System.out.println(result);//8

    }
}