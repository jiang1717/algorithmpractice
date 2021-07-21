package org.jiang.algorithms.classicsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortingMethodPracticeAgain {

    //冒泡排序
    //时间复杂度：n^2 n^2 n
    //空间复杂度：1
    //稳定
    public int[] bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return arr;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j + 1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    //选择排序
    //时间复杂度：n^2 n^2 n^2
    //空间复杂度：1
    //不稳定
    public int[] selectionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
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

    //插入排序
    //时间复杂度：n^2 n^2 n^2
    //空间复杂度：1
    //稳定
    public int[] straightInsertionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return arr;
        }

        for(int i = 1; i < arr.length; i++){
            int preIndex = i - 1;
            int cur = arr[i];
            while(preIndex >= 0 && cur < arr[preIndex]){
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = cur;
        }
        return arr;

    }

    //希尔排序
    //时间复杂度：n^2 n^1.3 n
    //空间复杂度：1
    //不稳定
    public int[] shellSort(int[] arr){
        if(arr == null || arr.length < 2){
            return arr;
        }
        int preIndex, cur;
        for (int gap = arr.length / 2; gap >0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                preIndex = i - gap;
                cur = arr[i];
                while(preIndex >= 0 && arr[preIndex] > cur){
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = cur;
            }
        }
        return arr;
    }

    //基数排序
    //时间复杂度：n*k n*k n*k
    //空间复杂度：n+k
    //稳定
    public int[] radixSort(int[] arr){
        if(arr == null || arr.length < 2){
            return arr;
        }

        int max = arr[0];
        for(int num : arr){
            if(num > max){
                max = num;
            }
        }

        int ratio = 1;
        while(max / 10 > 0){
            max /= 10;
            ratio++;
        }

        List<List<Integer>> backet = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            backet.add(new LinkedList<>());
        }
        for (int i = 0; i < ratio; i++) {
            for (int j = 0; j < arr.length; j++) {
                backet.get((arr[j] / (int)Math.pow(10, i)) % 10).add(arr[j]);
            }

            int k = 0;
            for (int j = 0; j < 10; j++) {
                for(Integer num : backet.get(j)){
                    arr[k++] = num;
                }
                backet.get(j).clear();
            }
        }
        return arr;

    }

    //桶排序
    //时间复杂度：n+k n*2 n
    //空间复杂度：n+k
    //稳定
    public int[] bucketSort(int[] arr){
        if(arr == null || arr.length < 2){
            return arr;
        }
        int min = arr[0], max = arr[0];
        for(int num : arr){
            if(num < min){
                min = num;
            }
            if(num > max){
                max = num;
            }
        }

        int n = (max - min) / 5 + 1;
        List<List<Integer>> backet = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            backet.add(new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            backet.get((arr[i] - min) / 5).add(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(backet.get(i));
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            for(Integer num : backet.get(i)){
                arr[k++] = num;
            }
        }
        return arr;
    }

    //快速排序
    //时间复杂度：nlogn n^2 nlogn
    //空间复杂度：nlogn
    //不稳定
    public int[] quickSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return arr;
        }

        return exchange(arr, 0, arr.length - 1);
    }

    public int[] exchange(int[] arr, int start, int end){

        if (start < end) {
            int mid = partition(arr, start, end);
            exchange(arr, start, mid - 1);
            exchange(arr, mid + 1, end);
        }
        return arr;
    }

    public int partition(int arr[], int start, int end){
        int pivot = start;
        int index = pivot + 1;
        for (int i = index; i <= end; i++) {
            if(arr[i] < arr[pivot]){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        int temp = arr[index-1];
        arr[index - 1] = arr[pivot];
        arr[pivot] = temp;

        return index - 1;
    }

    //归并排序
    //时间复杂度：nlogn nlogn nlogn
    //空间复杂度：n
    //稳定
    public int[] mergeSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return arr;
        }

        return mergeSort(arr, 0, arr.length - 1);
    }
    public int[] mergeSort(int[] arr, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
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
                temp[k++] = arr[i];
                i++;
            }else{
                temp[k++] = arr[j];
                j++;
            }
        }
        while(i <= mid){
            temp[k++] = arr[i];
            i++;
        }
        while (j <= end) {
            temp[k++] = arr[j];
            j++;
        }

        k = 0;
        for (int l = start; l <= end; l++) {
            arr[l] = temp[k++];
        }
        return;
    }

    //堆排序
    //时间复杂度：nlogn nlogn nlogn
    //空间复杂度：1
    //不稳定
    public int[] heapSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return arr;
        }

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length - 1);
        }

        for(int i = arr.length - 1; i >= 1; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjust(arr, 0, i - 1);
        }
        return arr;
    }

    public void adjust(int[] arr, int parent, int n){
        int child = 2 * parent + 1;
        while (child <= n) {
            if(child + 1 <= n && arr[child + 1] > arr[child]){
                child++;
            }
            if(arr[child] <= arr[parent]){
                break;
            }
            if(arr[child] > arr[parent]){
                int temp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = temp;
                parent = child;
                child = 2 * parent + 1;
            }
        }
        return;
    }

}
