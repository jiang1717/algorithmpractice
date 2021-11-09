package org.jiang.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. 所有可能的路径
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 *
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * 示例 2：
 *
 *
 *
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * 示例 3：
 *
 * 输入：graph = [[1],[]]
 * 输出：[[0,1]]
 * 示例 4：
 *
 * 输入：graph = [[1,2,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,2,3],[0,3]]
 * 示例 5：
 *
 * 输入：graph = [[1,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,3]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
 */

public class AllPathsFromSourceToTarget {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> subRes = new ArrayList<>();
        traverse(graph, 0, subRes);

        return res;
    }

    private void traverse(int[][] graph, int n, List<Integer> subRes) {
        subRes.add(n);
        if(n == graph.length - 1){
            res.add(new ArrayList<>(subRes));
            subRes.remove(subRes.size() - 1);
            return;
        }
        for(int i : graph[n]){
            traverse(graph, i, subRes);
        }
        subRes.remove(subRes.size() - 1);
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget test = new AllPathsFromSourceToTarget();
        int[][] arr = new int[][]{{1, 2}, {3}, {3}, {}};
        for(int[] ar : arr){
            for(int a : ar){
                System.out.println(a);
            }
        }
        System.out.println(test.allPathsSourceTarget(arr));
    }
}
