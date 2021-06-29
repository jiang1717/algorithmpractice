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

    @Test
    public void testMergeSort(){
        int[] result = sm.mergeSort(arr);
        printArray(result);
    }

    @Test
    public void testHeapSort(){
        int[] result = sm.heapSort(arr);
        printArray(result);
    }

    @Test
    public void testRadixSort(){
        int[] result = sm.radixSort(arr);
        printArray(result);
    }

    @Test
    public void testBucketSort(){
        int[] result = sm.bucketSort(arr);
        printArray(result);
    }

    @Test
    public void testCountingSort(){
        int[] result = sm.countingSort(arr);
        printArray(result);
        int[] result1 = sm.countingSort(new int[]{4,5,9,8,5,2,1,2,1,4,5,6,2,1,4});
        printArray(result1);
    }

}

