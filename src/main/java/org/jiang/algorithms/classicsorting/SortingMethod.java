package org.jiang.algorithms.classicsorting;


public class SortingMethod {
    /**
     * 插入排序：直接插入
     * 时间复杂度： 最坏     平均     最好
     *             O(n^2)   O(n^2)  O(n)
     * 空间复杂度：O(1)
     * 是否稳定： 稳定
     * 工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
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
     *             O(nlogn)   O(n^2)  O(nlogn)
     * 空间复杂度：O(nlogn)
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

}
