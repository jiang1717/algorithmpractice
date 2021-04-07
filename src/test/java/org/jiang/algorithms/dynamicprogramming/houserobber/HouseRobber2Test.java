package org.jiang.algorithms.dynamicprogramming.houserobber;

import org.junit.Test;


public class HouseRobber2Test {

    int[] nums;
    int result;

    HouseRobber2 hb = new HouseRobber2();


    @Test
    public void rob() {
        nums = new int[]{2, 3, 2};
        result = hb.rob(nums);
        System.out.println(result);//3

        nums = new int[]{1, 2, 3, 1};
        result = hb.rob(nums);
        System.out.println(result);//4

        nums = new int[]{0};
        result = hb.rob(nums);
        System.out.println(result);//0
    }
}