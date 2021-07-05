package org.jiang.algorithms.backtrackingalgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[["Q"]]
 *
 * 提示：
 *
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 *
 */

public class NQueens {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        res.clear();
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                s.append(".");
            }
            board.add(s.toString());
        }
        backtrack(0, board);
        return res;
    }

    private void backtrack(int row, List<String> board) {
        if(row == board.size()){
            res.add(new ArrayList<>(board));
            return;
        }
        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            if(!valid(board, row, col)){
                continue;
            }
            char[] c = board.get(row).toCharArray();
            c[col] = 'Q';
            board.set(row, String.valueOf(c));
            backtrack(row+1, board);
            c[col] = '.';
            board.set(row, String.valueOf(c));
        }
        return;
    }

    private boolean valid(List<String> board, int row, int col){
        int n = board.size();
        for (int i = row - 1; i >= 0; i--) {
            if(i < 0){
                return true;
            }
            char[] c = board.get(i).toCharArray();
            if(c[col] == 'Q'){
                return false;
            }
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if(i < 0 || j >= n){
                return true;
            }
            char[] c = board.get(i).toCharArray();
            if(c[j] == 'Q'){
                return false;
            }
        }
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(i < 0 || j < 0){
                return true;
            }
            char[] c = board.get(i).toCharArray();
            if(c[j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
