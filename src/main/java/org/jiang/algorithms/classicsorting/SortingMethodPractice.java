package org.jiang.algorithms.classicsorting;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class SortingMethodPractice {

    /**
     * 直接插入排序
     */
    public int[] straightInsertionSort(int[] arr){

        int cur, preIndex;
        for (int i = 1; i < arr.length; i++) {
            cur = arr[i];
            preIndex = i - 1;
            while(preIndex >= 0 && arr[preIndex] > cur){
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = cur;
        }

        return arr;
    }

    /**
     * 希尔排序
     */
    public int[] shellSort(int[] arr){

        int cur, preIndex;
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                cur = arr[i];
                preIndex = i - gap;
                while(preIndex >= 0 && arr[preIndex] > cur){
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = cur;
            }
        }
        return arr;
    }

    /**
     * 选择排序
     */
    public int[] selectionSort(int[] arr){
        if(arr == null && arr.length < 2){
            return arr;
        }

        int min, minIndex;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
        return arr;
    }

    /**
     * 冒泡排序
     */
    public int[] bubbleSort(int[] arr){

        if(arr == null || arr.length < 2){
            return arr;
        }

        int temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i ; j++) {
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 快速排序
     */
    public int[] quickSort(int[] arr){

        return exchange(arr, 0, arr.length-1);
    }

    public int[] exchange(int[] arr, int start, int end){
        if(arr == null || arr.length < 2){
            return arr;
        }

        if(start < end){
            int mid = partition(arr, start, end);
            exchange(arr, start, mid - 1);
            exchange(arr, mid + 1, end);
        }
        return arr;
    }

    public int partition(int[] arr, int start, int end){

        int cur = arr[start];
        int index = start + 1;
        int temp;
        for (int i = index; i <= end; i++) {
            if(arr[i] < cur){
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                index++;
            }
        }
        arr[start] = arr[index-1];
        arr[index-1] = cur;
        return index-1;
    }

    /**
     * 归并排序
     */
    public int[] mergeSort(int[] arr){
        return mergeSort(arr, 0, arr.length-1);
    }

    public int[] mergeSort(int[] arr, int start, int end){
        if(arr == null || arr.length < 2){
            return arr;
        }

        if(start < end){
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr,mid + 1, end);
            merge(arr, start, mid, end);
        }
        return arr;
    }

    public void merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= end){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= end){
            temp[k++] = arr[j++];
        }
        for (int l = 0; l < k; l++) {
            arr[start + l] = temp[l];
        }
    }

    /**
     * 堆排序
     */
    public int[] heapSort(int[] arr){

        if(arr == null || arr.length < 2){
            return arr;
        }

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length - 1);
        }

        int temp;
        for (int i = arr.length - 1; i >= 1 ; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjust(arr, 0, i-1);
        }

        return arr;
    }

    public void adjust(int[] arr, int parent, int n){
        int child = 2 * parent + 1;
        int temp;
        while(child <= n){
            if(child + 1 <= n && arr[child + 1] > arr[child]){
                child++;
            }
            //终止条件
            if(arr[child] <= arr[parent]){
                break;
            }
            temp = arr[parent];
            arr[parent] = arr[child];
            arr[child] = temp;
            parent = child;
            child = 2 * parent + 1;
        }
    }

    /**
     * 基数排序
     */
    public int[] radixSort(int[] arr){
        if(arr == null || arr.length < 2){
            return arr;
        }

        //计算最大值指数

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int num = 1;
        while(max / 10 > 0){
            num++;
            max /= 10;
        }
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            bucketList.add(new LinkedList<Integer>());
        }

        //从个位开始循环排序
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < arr.length; j++) {
                bucketList.get((arr[j] / (int)Math.pow(10, i - 1)) % 10).add(arr[j]);
            }
            int k = 0;
            for (int j = 0; j < 10; j++) {
                for(int l : bucketList.get(j)){
                    arr[k++] = l;
                }
                bucketList.get(j).clear();
            }
        }
        return arr;
    }

    /**
     * 桶排序
     */
    public int[] bucketSort(int[] arr){
        if(arr == null || arr.length < 2){
            return arr;
        }

        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }

        int size = (max - min) / 5 + 1;

        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            bucketList.add(new LinkedList<Integer>());
        }

        for (int i = 0; i < arr.length; i++) {
            int ratio = (arr[i] - min) / 5;
            bucketList.get(ratio).add(arr[i]);
        }

        int k = 0;
        for (int i = 0; i < size; i++) {
            Collections.sort(bucketList.get(i));
            for(int t : bucketList.get(i)){
                arr[k++] = t;
            }
        }
        return arr;
    }

    /**
     * 计数排序
     */
    public int[] countingSort(int[] arr){
        if(arr == null || arr.length < 2){
            return arr;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }

        int[] count = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[k++] = min + i;
            }
        }
        return arr;
    }


}
