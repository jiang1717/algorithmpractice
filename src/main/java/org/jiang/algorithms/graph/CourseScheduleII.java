package org.jiang.algorithms.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 210. 课程表 II
 *
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 *
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii
 */

public class CourseScheduleII {
    boolean[] exist;
    boolean hascircle = false;
    List<Integer> res;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new LinkedList<>();
        //构建图，邻接链表
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for(int[] pre : prerequisites){
            int from = pre[1];
            int to = pre[0];
            graph[from].add(to);
        }
        exist = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(i, graph);
        }
        if(hascircle || res == null || res.size() == 0){
            return new int[]{};
        }
        int[] arr = new int[numCourses];
        int k = numCourses;
        for(int i : res){
            arr[--k] = i;
        }
        return arr;
    }

    private void traverse(int n, List<Integer>[] graph) {
        if(exist[n]){
            hascircle = true;
            return;
        }
        if(res.size() == graph.length){
            return;
        }
        if(hascircle){
            return;
        }
        exist[n] = true;
        res.add(n);
        for(int i : graph[n]){
            traverse(i, graph);
        }
        exist[n] = false;
        if(res.size() == graph.length){
            return;
        }
        res.remove(res.size() - 1);
        return;
    }

    public static void main(String[] args) {
        CourseScheduleII test = new CourseScheduleII();
        for(int i : test.findOrder(2, new int[][]{{1, 0}})){
            System.out.println(i);
        };
    }
}
