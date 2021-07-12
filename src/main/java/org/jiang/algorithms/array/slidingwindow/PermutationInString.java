package org.jiang.algorithms.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 */

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        for(char c : s1.toCharArray()){
            int n = need.getOrDefault(c, 0);
            need.put(c, n + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int start = 0;
        int valid = 0;
        while(right < s2.length()){
            char r = s2.charAt(right);
            right++;
            if (need.containsKey(r)) {
                int n = window.getOrDefault(r, 0);
                window.put(r, n + 1);
                if(window.get(r).equals(need.get(r))){
                    valid++;
                }
            }

            while(right - left >= s1.length()){
                if(valid == need.size()){
                    return true;
                }
                char l = s2.charAt(left);
                left++;
                if(need.containsKey(l)){
                    int n = window.get(l);
                    if(window.get(l).equals(need.get(l))){
                        valid--;
                    }
                    window.put(l, n - 1);
                }
            }
        }
        return false;
    }
}
