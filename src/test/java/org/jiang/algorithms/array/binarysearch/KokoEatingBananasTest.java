package org.jiang.algorithms.array.binarysearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class KokoEatingBananasTest {
    int H;
    int[] piles;
    int result;

    KokoEatingBananas keb = new KokoEatingBananas();


    @Test
    public void testMinEatingSpeed() {
        piles = new int[]{3,6,7,11};
        H = 8;
        result = keb.minEatingSpeed(piles, H);
        System.out.println(result);//4

        piles = new int[]{30,11,23,4,20};
        H = 5;
        result = keb.minEatingSpeed(piles, H);
        System.out.println(result);//30

        piles = new int[]{30,11,23,4,20};
        H = 6;
        result = keb.minEatingSpeed(piles, H);
        System.out.println(result);//23
    }
}