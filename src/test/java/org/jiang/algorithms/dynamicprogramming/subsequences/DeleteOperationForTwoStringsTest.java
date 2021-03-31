package org.jiang.algorithms.dynamicprogramming.subsequences;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteOperationForTwoStringsTest {

    String word1;
    String word2;
    int result;

    DeleteOperationForTwoStrings dots = new DeleteOperationForTwoStrings();

    @Test
    public void minDistance() {
        word1 = "sea";
        word2 = "eat";
        result = dots.minDistance(word1, word2);
        System.out.println(result);
    }
}