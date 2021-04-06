package org.jiang.algorithms.dynamicprogramming.greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGame2Test {

    int[] nums;
    int result;

    JumpGame2 jg = new JumpGame2();

    @Test
    public void jump() {
        nums = new int[]{2, 3, 1, 1, 4};
        result = jg.jump(nums);
        System.out.println(result);//2
    }
}