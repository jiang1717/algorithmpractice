package org.jiang.algorithms.dynamicprogramming.greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class NonOverlappingIntervalsTest {

    int[][] intervals;
    int result;

    NonOverlappingIntervals noi = new NonOverlappingIntervals();

    @Test
    public void eraseOverlapIntervals() {
        intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        result = noi.eraseOverlapIntervals(intervals);
        System.out.println(result);//1

        intervals = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        result = noi.eraseOverlapIntervals(intervals);
        System.out.println(result);//2

        intervals = new int[][]{{1, 2}, {2, 3}};
        result = noi.eraseOverlapIntervals(intervals);
        System.out.println(result);//0

        intervals = new int[][]{{}};
        result = noi.eraseOverlapIntervals(intervals);
        System.out.println(result);//0

    }
}