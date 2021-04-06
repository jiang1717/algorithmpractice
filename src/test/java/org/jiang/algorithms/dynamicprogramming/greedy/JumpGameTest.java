package org.jiang.algorithms.dynamicprogramming.greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameTest {

    int[] nums;
    boolean result;

    JumpGame jg = new JumpGame();

    @Test
    public void canJump() {
        nums = new int[]{2, 3, 1, 1, 4};
        result = jg.canJump(nums);
        System.out.println(result);//true

        nums = new int[]{3, 2, 1, 0, 4};
        result = jg.canJump(nums);
        System.out.println(result);//false

    }
}