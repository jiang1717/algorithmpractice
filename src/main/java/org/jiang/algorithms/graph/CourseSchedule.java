package org.jiang.algorithms.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 */

public class CourseSchedule {
    boolean[] exist;
    //visited数组是用剪枝的，否则会超时。
    boolean[] visited;
    boolean hascircle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(i, graph);
        }
        return !hascircle;
    }

    private void traverse(int n, List<Integer>[] graph) {
        if(exist[n]){
            hascircle = true;
            return;
        }
        if(visited[n] || hascircle){
            return;
        }
        visited[n] = true;
        exist[n] = true;
        for(int i : graph[n]){
            traverse(i, graph);
        }
        exist[n] = false;
        return;
    }
}
