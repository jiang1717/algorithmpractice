package org.jiang.algorithms.dynamicprogramming.subsequences;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *  
 *
 * 提示：
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 *
 */
public class EditDistance {

    char[] c1;
    char[] c2;

    //暴力求解
    public int minDistance1(String word1, String word2) {
        c1 = word1.toCharArray();
        c2 = word2.toCharArray();
        return dp1(c1.length - 1, c2.length - 1);
    }

    public int dp1(int i, int j){
        if(i == -1){
            return j + 1;
        }
        if(j == -1){
            return i + 1;
        }
        if(c1[i] == c2[j]){
            return dp1(i - 1, j - 1);
        }else{
            //插入、删除、替换
            return getMin(dp1(i, j - 1), dp1(i - 1, j), dp1(i - 1, j - 1)) + 1;
        }
    }

    public int getMin(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }

    //自顶向下 memo数组
    int[][] memo;
    public int minDistance2(String word1, String word2) {
        c1 = word1.toCharArray();
        c2 = word2.toCharArray();
        memo = new int[c1.length][c2.length];
        for (int i = 1; i < c1.length + 1; i++) {
            memo[i][0] = i + 1;
        }
        for (int j = 1; j < c2.length + 1; j++) {
            memo[0][j] = j + 1;
        }

        return dp2(c1.length - 1, c2.length - 1);
    }

    public int dp2(int i, int j){
        if(i == -1){
            return j + 1;
        }
        if(j == -1){
            return i + 1;
        }
        if(memo[i][j] > 0){
            return memo[i][j];
        }

        if(c1[i] == c2[j]){
            memo[i][j] = dp2(i - 1, j - 1);
        }else{
            memo[i][j] = getMin(dp2(i, j - 1), dp2(i - 1, j), dp2(i - 1, j - 1)) + 1;
    }

        return memo[i][j];
    }


}
