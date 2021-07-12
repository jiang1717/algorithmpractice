package org.jiang.algorithms.array.slidingwindow;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersTest {

    String s;
    int res;
    LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();

    @Test
    public void lengthOfLongestSubstring() {
        s = "abcabcbb";
        res = lswrc.lengthOfLongestSubstring(s);
        System.out.println(res);//3

        s = "bbbbb";
        res = lswrc.lengthOfLongestSubstring(s);
        System.out.println(res);//1

        s = "pwwkew";
        res = lswrc.lengthOfLongestSubstring(s);
        System.out.println(res);//3

        s = "";
        res = lswrc.lengthOfLongestSubstring(s);
        System.out.println(res);//0


    }
}