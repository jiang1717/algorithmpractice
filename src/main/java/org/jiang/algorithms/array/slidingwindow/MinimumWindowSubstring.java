package org.jiang.algorithms.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 */

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        //记录需要的字母及个数
        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()){
            int n = need.getOrDefault(c, 0);
            need.put(c, n + 1);
        }
        //记录窗口内的字母及个数
        Map<Character, Integer> window = new HashMap<>();

        //记录窗口范围
        int left = 0;
        int right = 0;

        //窗口内满足要求的字符个数，当其等于need.size()时，所有要求的字母都在当前窗口内
        int valid = 0;

        //记录符合要求的字符串的位置及长度
        int start = 0;
        int len = Integer.MAX_VALUE;

        //窗口的右侧要遍历到字符串的最后一位
        while(right < s.length()){
            //将右边的字符加入窗口
            char r = s.charAt(right);
            right++;
            if(need.containsKey(r)){
                int n = window.getOrDefault(r, 0);
                window.put(r, n + 1);
                if(window.get(r).equals(need.get(r))){
                    valid++;
                }
            }

            while(valid == need.size()){
                //更新最小覆盖串
                if(right - left <= len){
                    start = left;
                    len = right - left;
                }
                //将左边的字符推出窗口
                char l = s.charAt(left);
                left++;
                if(need.containsKey(l)){
                    int m = window.get(l);
                    if(window.get(l).equals(need.get(l))){
                        valid--;
                    }
                    window.put(l, m - 1);
                }
            }
        }
        if(len != Integer.MAX_VALUE){
            char[] res = new char[len];
            for (int i = 0; i < len; i++) {
                res[i] = s.charAt(start + i);
            }
            return new String(res);
        }else{
            return "";
        }
    }
}
