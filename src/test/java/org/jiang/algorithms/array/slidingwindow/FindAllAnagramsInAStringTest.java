package org.jiang.algorithms.array.slidingwindow;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FindAllAnagramsInAStringTest {

    String s;
    String p;
    List<Integer> res;
    FindAllAnagramsInAString faaias = new FindAllAnagramsInAString();

    @Test
    public void findAnagrams() {
        s = "cbaebabacd";
        p = "abc";
        res = faaias.findAnagrams(s, p);//0 6
        System.out.println(res);

        s = "abab";
        p = "ab";
        res = faaias.findAnagrams(s, p);//0 1 2
        System.out.println(res);
    }
}