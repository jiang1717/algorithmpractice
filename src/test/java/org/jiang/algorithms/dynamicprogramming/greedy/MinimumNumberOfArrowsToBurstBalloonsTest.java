package org.jiang.algorithms.dynamicprogramming.greedy;

import org.jiang.algorithms.dynamicprogramming.subsequences.MinimumAsciiDeleteSumForTwoStrings;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumNumberOfArrowsToBurstBalloonsTest {

    int[][] points;
    int result;

    MinimumNumberOfArrowsToBurstBalloons mnabb = new MinimumNumberOfArrowsToBurstBalloons();

    @Test
    public void findMinArrowShots() {
        points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        result = mnabb.findMinArrowShots(points);
        System.out.println(result);//2

        points = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        result = mnabb.findMinArrowShots(points);
        System.out.println(result);//4

        points = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        result = mnabb.findMinArrowShots(points);
        System.out.println(result);//2

        points = new int[][]{{1, 2}};
        result = mnabb.findMinArrowShots(points);
        System.out.println(result);//1

        points = new int[][]{{2, 3}, {2, 3}};
        result = mnabb.findMinArrowShots(points);
        System.out.println(result);//1

        //因为差值过大而产生溢出。sort的时候不要用a-b来比较，要用Integer.compare(a, b)!!!
        points = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
        result = mnabb.findMinArrowShots(points);
        System.out.println(result);//2

    }
}