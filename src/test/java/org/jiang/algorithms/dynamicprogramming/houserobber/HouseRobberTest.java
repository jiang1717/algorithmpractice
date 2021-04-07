package org.jiang.algorithms.dynamicprogramming.houserobber;

import org.junit.Test;

import static org.junit.Assert.*;

public class HouseRobberTest {

    int[] nums;
    int result;

    HouseRobber hb = new HouseRobber();


    @Test
    public void rob() {
        nums = new int[]{1,2,3,1};
        result = hb.rob(nums);
        System.out.println(result);//4

        nums = new int[]{2,7,9,3,1};
        result = hb.rob(nums);
        System.out.println(result);//12
    }
}