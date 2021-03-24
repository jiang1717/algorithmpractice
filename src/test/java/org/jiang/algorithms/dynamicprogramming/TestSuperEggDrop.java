package org.jiang.algorithms.dynamicprogramming;

import org.junit.Test;

public class TestSuperEggDrop {
    int k, n;
    int result;
    SuperEggDrop seg = new SuperEggDrop();

    @Test
    public void testSuperEggDrop1() {
        k = 1;
        n = 2;
        result = seg.superEggDrop1(k, n);
        System.out.println(result);

        k = 2;
        n = 6;
        result = seg.superEggDrop1(k, n);
        System.out.println(result);

        k = 3;
        n = 14;
        result = seg.superEggDrop1(k, n);
        System.out.println(result);
    }
}