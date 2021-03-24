package org.jiang.algorithms.classicsorting;


public class SortingMethod {
    /**
     * 插入排序：直接插入
     * 时间复杂度： 最坏     平均     最好
     *             O(n^2)   O(n^2)  O(n)
     * 空间复杂度：O(1)
     * 是否稳定： 稳定
     */
    public int[] straightInsertionSort(int[] arr){
        int cur, preIndex;
        for(int i = 1; i < arr.length; i++){
            cur = arr[i];
            preIndex = i-1;
            while(preIndex >= 0 && arr[preIndex] > cur){
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = cur;
        }
        return arr;
    }

    /**
     * 插入排序：希尔排序
     * 时间复杂度： 最坏     平均       最好
     *             O(n^2)   O(n^1.3)  O(n)
     * 空间复杂度：O(1)
     * 是否稳定： 不稳定
     */
    public int[] shellSort(int[] arr){
        int cur, preIndex;
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            for(int i = gap; i < arr.length; i++){
                preIndex = i - gap;
                cur = arr[i];
                while(preIndex >=0 && arr[preIndex] > cur){
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = cur;
            }
        }
        return arr;
    }
}
