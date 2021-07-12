package org.jiang.algorithms.array.slidingwindow;

import org.junit.Test;

import static org.junit.Assert.*;

public class PermutationInStringTest {

    String s1;
    String s2;
    boolean res;
    PermutationInString pis = new PermutationInString();

    @Test
    public void checkInclusion() {
        s1 = "ab";
        s2 = "eidbaooo";
        res = pis.checkInclusion(s1, s2);
        System.out.println(res);

        s1 = "ab";
        s2 = "eidboaoo";
        res = pis.checkInclusion(s1, s2);
        System.out.println(res);
    }
}