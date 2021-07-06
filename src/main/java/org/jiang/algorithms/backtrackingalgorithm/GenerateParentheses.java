package org.jiang.algorithms.backtrackingalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 */

public class GenerateParentheses {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        res.clear();
        if(n <= 0){
            return null;
        }

        StringBuilder track = new StringBuilder();
        backtrack(n, n, track);
        return res;
    }

    public void backtrack(int left, int right, StringBuilder track){
        if(left < 0 || right < 0){
            return;
        }
        if(right < left){
            return;
        }
        if(left == 0 && right == 0){
            res.add(new String(track));
        }

        track.append('(');
        backtrack(left - 1, right, track);
        track.deleteCharAt(track.length() - 1);

        track.append(')');
        backtrack(left, right - 1, track);
        track.deleteCharAt(track.length() - 1);
    }
}
