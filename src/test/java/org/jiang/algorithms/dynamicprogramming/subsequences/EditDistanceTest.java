package org.jiang.algorithms.dynamicprogramming.subsequences;

import org.junit.Test;

import static org.junit.Assert.*;

public class EditDistanceTest {
    EditDistance ed = new EditDistance();
    //3, 5, 0, 1
    String[] word1 = {"horse", "intention", "", "a"};
    String[] word2 = {"ros", "execution", "", "ab"};

    @Test
    public void testMinDistance1() {
        int steps;
        for (int i = 0; i < word1.length; i++) {
            steps = ed.minDistance1(word1[i], word2[i]);
            System.out.println(steps);
        }
    }

    @Test
    public void testMinDistance2() {
        int steps;
        for (int i = 0; i < word1.length; i++) {
            steps = ed.minDistance2(word1[i], word2[i]);
            System.out.println(steps);
        }
    }

    @Test
    public void testMinDistance3() {
        int steps;
        for (int i = 0; i < word1.length; i++) {
            steps = ed.minDistance3(word1[i], word2[i]);
            System.out.println(steps);
        }
    }
}