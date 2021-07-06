package org.jiang.algorithms.backtrackingalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 */

public class Combinations {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        res.clear();
        if(k > n || n < 1 || k < 1){
            return null;
        }

        List<Integer> track = new ArrayList<>();
        backtrack(n, k, track, 1);
        return res;
    }

    public void backtrack(int n, int k, List<Integer> track, int start){
        if(track.size() == k){
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, track, i+1);
            track.remove(track.size() - 1);
        }
    }
}
