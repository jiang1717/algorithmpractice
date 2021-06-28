package org.jiang.algorithms.classicsorting;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class TestSortingMethod {

    public int[] arr = new int[]{45, 98, 546, 213, 4844, 0, 396};
    public SortingMethod sm = new SortingMethod();

    public void printArray(int[] arr){
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    @Test
    public void testStraightInsertionSort(){
        int[] result = sm.straightInsertionSort(arr);
        printArray(result);
    }

    @Test
    public void testShellSort(){
        int[] result = sm.shellSort(arr);
        printArray(result);
    }

    @Test
    public void testSelectionSort(){
        int[] result = sm.selectionSort(arr);
        printArray(result);
    }

    @Test
    public void testBubbleSort(){
        int[] result = sm.bubbleSort(arr);
        printArray(result);
    }

    @Test
    public void testQuickSort(){
        int[] result = sm.quickSort(arr);
        printArray(result);
    }

}

