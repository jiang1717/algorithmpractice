package org.jiang.algorithms.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 710. 黑名单中的随机数
 * 给定一个包含 [0，n) 中不重复整数的黑名单 blacklist ，写一个函数从 [0, n) 中返回一个不在 blacklist 中的随机整数。
 *
 * 对它进行优化使其尽量少调用系统方法 Math.random() 。
 *
 * 提示:
 *
 * 1 <= n <= 1000000000
 * 0 <= blacklist.length < min(100000, N)
 * [0, n) 不包含 n ，详细参见 interval notation 。
 * 示例 1：
 *
 * 输入：
 * ["Solution","pick","pick","pick"]
 * [[1,[]],[],[],[]]
 * 输出：[null,0,0,0]
 * 示例 2：
 *
 * 输入：
 * ["Solution","pick","pick","pick"]
 * [[2,[]],[],[],[]]
 * 输出：[null,1,1,1]
 * 示例 3：
 *
 * 输入：
 * ["Solution","pick","pick","pick"]
 * [[3,[1]],[],[],[]]
 * 输出：[null,0,0,2]
 * 示例 4：
 *
 * 输入：
 * ["Solution","pick","pick","pick"]
 * [[4,[2]],[],[],[]]
 * 输出：[null,1,3,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-with-blacklist
 */

public class RandomPickWithBlacklist {
    public Map<Integer, Integer> mapping;
    public int sz;

    public RandomPickWithBlacklist(int n, int[] blacklist) {

        sz = n - blacklist.length;
        mapping = new HashMap<>();
        for(int b : blacklist){
            mapping.put(b, -1);
        }
        int index = n - 1;
        for(int b : blacklist){
            if(b >= sz){
                continue;
            }
            while(mapping.containsKey(index)){
                index--;
            }
            mapping.put(b, index);
            index--;
        }

    }

    public int pick() {
        int index = (int)(Math.random() * sz);
        if(mapping.containsKey(index)){
            return mapping.get(index);
        }
        return index;
    }
}
