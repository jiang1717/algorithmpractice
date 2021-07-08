package org.jiang.algorithms.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertDeleteGetrandomO1Test {

    public static void main(String[] args) {
//        ["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
//          [[],[0],[1],[0],[2],[1],[]]
        InsertDeleteGetrandomO1 obj = new InsertDeleteGetrandomO1();
        System.out.println(obj.insert(0));
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(2));
        System.out.println(obj.remove(1));
        System.out.println(obj.getRandom());

        System.out.println(obj.nums);

    }


}