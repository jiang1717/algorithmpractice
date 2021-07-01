package org.jiang.algorithms.array.binarysearch;

/**
 * 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。
 * 我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 *
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 *
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 */

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        //二分搜索，每天运输的重量w，最大值为sum(weights)，最小值为max(weights)
        //存在一个w区间使得运送天数d等于days，取左边界
        int left = weights[0];
        int right = weights[0];
        for (int i = 1; i < weights.length; i++) {
            if(weights[i] > left){
                left = weights[i];
            }
            right += weights[i];
        }

        //二分搜索
        while(left <= right){
            int mid = left + (right - left) / 2;
            int d = getDays(weights, mid);
            if(d > days){
                left = mid + 1;
            }else if(d < days){
                right = mid -  1;
            }else if(d == days){
                right = mid - 1;
            }
        }

        return left;
    }

    public int getDays(int[] weights, int w){

        int sum = 0;
        int d = 0;

        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if(sum > w){
                sum = 0;
                d++;
                i--;
            }
        }
        if(sum > 0){
            d++;
        }

        return d;
    }
}
