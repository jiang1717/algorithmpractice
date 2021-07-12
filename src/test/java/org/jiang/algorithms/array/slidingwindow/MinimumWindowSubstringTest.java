package org.jiang.algorithms.array.slidingwindow;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumWindowSubstringTest {

    String s;
    String t;
    String res;
    MinimumWindowSubstring mws = new MinimumWindowSubstring();


    @Test
    public void minWindow() {
        s = "ADOBECODEBANC";
        t = "ABC";
        res = mws.minWindow(s, t);
        System.out.println(res);// BANC

        s = "A";
        t = "A";
        res = mws.minWindow(s, t);
        System.out.println(res);//A
    }
}