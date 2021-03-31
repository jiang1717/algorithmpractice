package org.jiang.algorithms.dynamicprogramming.subsequences;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonSubsequenceTest {

    String text1;
    String text2;
    int result;
    LongestCommonSubsequence lcs = new LongestCommonSubsequence();

    @Test
    public void longestCommonSubsequence() {
        text1 = "abcde";
        text2 = "ace";
        result = lcs.longestCommonSubsequence(text1, text2);
        System.out.println(result);

        text1 = "abc";
        text2 = "abc";
        result = lcs.longestCommonSubsequence(text1, text2);
        System.out.println(result);

        text1 = "abc";
        text2 = "def";
        result = lcs.longestCommonSubsequence(text1, text2);
        System.out.println(result);

    }
}