package org.jiang.algorithms.classicsorting;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class SortingMethod {
    /**
     * 插入排序：直接插入
     * 时间复杂度： 最坏     平均     最好
     *             O(n^2)   O(n^2)  O(n)
     * 空间复杂度：O(1)
     * 是否稳定： 稳定
     * 工作原理是通过构建有序序列，对于未排序数据，
     * 在已排序序列中从后向前扫描，找到相应位置并插入。
     *
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
     * 它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
     *
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

    /**
     * 选择排序
     * 时间复杂度： 最坏     平均       最好
     *             O(n^2)   O(n^2)  O(n^2)
     * 空间复杂度：O(1)
     * 是否稳定： 不稳定
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     *
     */
    public int[] selectionSort(int[] arr){
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    /**
     * 冒泡排序
     * 时间复杂度： 最坏     平均       最好
     *             O(n^2)   O(n^2)  O(n)
     * 空间复杂度：O(1)
     * 是否稳定： 稳定
     * 它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
     *
     */
    public int[] bubbleSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = arr.length; i >= 0; i--) {
            for (int j = 0; j < i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 快速排序
     * 时间复杂度： 最坏     平均       最好
     *             O(n^2)   O(nlogn)  O(nlogn)
     * 空间复杂度：O(logn)
     * 是否稳定： 不稳定
     * 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
     * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     *
     */
    public int[] quickSort(int[] arr){

        return exchange(arr, 0, arr.length-1);
    }

    public int[] exchange(int[] arr, int start, int end){
        if(start < end){
            int mid = partition(arr, start, end);
            exchange(arr, start, mid-1);
            exchange(arr, mid+1, end);
        }
        return arr;
    }

    public int partition(int[] arr, int start, int end){
        // pivot：分界元素
        int pivot = start;
        // index：大于pivot和小于pivot的分界线
        int index = pivot + 1;
        for (int i = index; i <= end; i++) {
            if(arr[i] < arr[pivot]){
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
                index++;
            }
        }
        // 将分界元素移动到分界线之前
        int tmp = arr[index-1];
        arr[index-1] = arr[pivot];
        arr[pivot] = tmp;

        return index-1;
    }

    /**
     * 归并排序
     * 时间复杂度： 最坏     平均       最好
     *             O(nlogn)   O(nlogn)  O(nlogn)
     * 空间复杂度：O(n)
     * 是否稳定： 稳定
     * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
     * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
     * 若将两个有序表合并成一个有序表，称为2-路归并。
     *
     */

    public int[] mergeSort(int[] arr){
        return mergeSort(arr, 0, arr.length-1);
    }

    public int[] mergeSort(int[] arr, int start, int end){
        if(start < end){
            int mid = start + (end - start) / 2;
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
            arr[start++] = temp[l];
        }
    }

    /**
     * 堆排序
     * 时间复杂度： 最坏     平均       最好
     *             O(nlogn)   O(nlogn)  O(nlogn)
     * 空间复杂度：O(1)
     * 是否稳定： 不稳定
     * 是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，
     * 并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
     *
     * 大顶堆的构建过程就是从最后一个非叶子结点开始从下往上调整。
     * 大顶堆的排序过程就是不断将堆顶元素放到叶子结点，进行调整
     */

    public int[] heapSort(int[] arr){

        //构建大顶堆，从最后一个非叶子结点开始从下往上调整
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length - 1);
        }

        //进行排序, 不断将堆顶元素放到叶子结点，进行调整
        for (int i = arr.length - 1; i >=1 ; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //第i个值已经是最大值了，所以只用调整前面的元素
            adjust(arr, 0, i - 1);
        }

        return arr;
    }

    public void adjust(int[] arr, int parent, int n){
        //计算左孩子位置
        int temp;
        int child = 2 * parent + 1;
        while(child <= n){
            if(child + 1 <= n && arr[child + 1] > arr[child]){
                child++;
            }
            //终止条件
            if(arr[child] <= arr[parent]){
                break;
            }
            if(arr[child] > arr[parent]){
                temp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = temp;
                parent = child;
                child = 2 * parent + 1;
            }

        }
    }

    /**
     * 基数排序
     * 时间复杂度： 最坏     平均       最好
     *             O(n*k)   O(n*k)  O(n*k)
     * 空间复杂度：O(n+k)
     * 是否稳定： 稳定
     *
     * 按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
     *
     */
    public int[] radixSort(int[] arr){
        if(arr == null || arr.length < 2){
            return arr;
        }

        int n = arr.length;
        //找到最大值，确定最大值的位数num
        int max = arr[0];
        for(int i : arr){
            if(i > max){
                max = i;
            }
        }
        int num = 1;
        while(max / 10 > 0){
            num++;
            max /= 10;
        }

        //创建10个桶，分别装基数0-9的数字
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            bucketList.add(new LinkedList<Integer>());
        }

        //开始排序，从个位开始
        for (int i = 1; i <= num; i++) {
            //对第i位进行排序

            // 将数据放入桶中
            for (int j = 0; j < n; j++) {
                int ratio = (arr[j] / (int)Math.pow(10, i-1)) % 10;
                bucketList.get(ratio).add(arr[j]);
            }

            //将数据从桶中拿出来放回原数组，并清空桶
            int k = 0;
            for (int j = 0; j < 10; j++) {
                for(Integer t : bucketList.get(j)){
                    arr[k++] = t;
                }
                bucketList.get(j).clear();
            }
        }
        return arr;
    }

    /**
     * 桶排序
     * 时间复杂度： 最坏     平均       最好
     *             O(n+k)   O(n*2)  O(n)
     * 空间复杂度：O(n+k)
     * 是否稳定： 稳定
     *
     * 是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
     * 桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，
     * 每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。
     *
     */

    public int[] bucketSort(int[] arr){

        if(arr == null || arr.length < 2){
            return arr;
        }

        int max = arr[0], min = arr[0];
        for(int i : arr){
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }
        }

        //创建桶，每个桶存放 5*i~5*i+4
        int n = (max - min)/5 + 1;
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            bucketList.add(new LinkedList<Integer>());
        }

        //将元素放入桶中
        for (int i = 0; i < arr.length; i++) {
            int ratio = (arr[i] - min) / 5;
            bucketList.get(ratio).add(arr[i]);
        }
        //对桶内元素进行排序
        for (int i = 0; i < n; i++) {
            Collections.sort(bucketList.get(i));
        }
        //将桶内数据还原到数组中
        int k = 0;
        for (int i = 0; i < n; i++) {
            for(Integer t : bucketList.get(i)){
                arr[k++] = t;
            }
        }
        return arr;
    }

    /**
     * 计数排序
     * 时间复杂度： 最坏     平均       最好
     *             O(n+k)   O(n+k)  O(n+k)
     * 空间复杂度：O(n+k)
     * 是否稳定： 稳定
     *
     * 将输入的数据值转化为键存储在额外开辟的数组空间中。
     * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
     *
     */

    public int[] countingSort(int[] arr){

        if(arr == null || arr.length < 2){
            return arr;
        }
        int max = arr[0], min = arr[0];
        for(int num : arr){
            if(num > max){
                max = num;
            }
            if (num < min){
                min = num;
            }
        }

        int size = max - min + 1;
        int[] temp = new int[size];

        //统计每个元素出现的次数
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i] - min]++;
        }

        //将数据还原回原数组
        int k = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i]; j++) {
                arr[k++] = i + min;
            }
        }
        return arr;
    }
}
