package org.jiang.algorithms.array.binarysearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class CapacityToShipPackagesWithinDDaysTest {

    int[] weights;
    int D;
    int result;
    CapacityToShipPackagesWithinDDays atpwdd = new CapacityToShipPackagesWithinDDays();

    @Test
    public void testShipWithinDays() {
        weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        D = 5;
        result = atpwdd.shipWithinDays(weights, D);//15
        System.out.println(result);

        weights = new int[]{3,2,2,4,1,4};
        D = 3;
        result = atpwdd.shipWithinDays(weights, D);//6
        System.out.println(result);

        weights = new int[]{1,2,3,1,1};
        D = 4;
        result = atpwdd.shipWithinDays(weights, D);//3
        System.out.println(result);

    }
}