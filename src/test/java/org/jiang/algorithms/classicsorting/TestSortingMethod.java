package org.jiang.algorithms.classicsorting;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class TestSortingMethod {

    public int[] arr = new int[]{45, 98, 546, 213, 4844, 0, 396};
    public SortingMethod sm = new SortingMethod();
    public SortingMethodPractice sm1 = new SortingMethodPractice();

    public void printArray(int[] arr){
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    @Test
    public void testStraightInsertionSort(){
        int[] result = sm1.straightInsertionSort(arr);
        printArray(result);
    }

    @Test
    public void testShellSort(){
        int[] result = sm1.shellSort(arr);
        printArray(result);
    }

    @Test
    public void testSelectionSort(){
        int[] result = sm1.selectionSort(arr);
        printArray(result);
    }

    @Test
    public void testBubbleSort(){
        int[] result = sm1.bubbleSort(arr);
        printArray(result);
    }

    @Test
    public void testQuickSort(){
        int[] result = sm1.quickSort(arr);
        printArray(result);
    }

    @Test
    public void testMergeSort(){
        int[] result = sm1.mergeSort(arr);
        printArray(result);
    }

    @Test
    public void testHeapSort(){
        int[] result = sm1.heapSort(arr);
        printArray(result);
    }

    @Test
    public void testRadixSort(){
        int[] result = sm1.radixSort(arr);
        printArray(result);
    }

    @Test
    public void testBucketSort(){
        int[] result = sm1.bucketSort(arr);
        printArray(result);
        int[] result1 = sm1.bucketSort(new int[]{1,2,3,4,5,6,7,8,9});
        printArray(result1);
    }

    @Test
    public void testCountingSort(){
        int[] result = sm1.countingSort(arr);
        printArray(result);
        int[] result1 = sm1.countingSort(new int[]{4,5,9,8,5,2,1,2,1,4,5,6,2,1,4});
        printArray(result1);
    }

}

