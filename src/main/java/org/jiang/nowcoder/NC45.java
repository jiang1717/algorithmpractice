package org.jiang.nowcoder;

import java.util.LinkedList;
import java.util.List;

/**
 * NC45 实现二叉树先序，中序和后序遍历
 * 描述
 * 分别按照二叉树先序，中序和后序打印所有的节点。
 * 示例1
 * 输入：
 * {1,2,3}
 * 返回值：
 * [[1,2,3],[2,1,3],[2,3,1]]
 */

public class NC45 {
    List<List<Integer>> res = new LinkedList<>();
    public int[][] threeOrders (TreeNode root) {
        // write code here
//         if()
        res.add(new LinkedList<>());
        res.add(new LinkedList<>());
        res.add(new LinkedList<>());
        oder(root);
        int[][] result = new int[3][res.get(0).size()];
        for(int i = 0; i < 3; i++){
            int k = 0;
            for(Integer n : res.get(i)){
                result[i][k++] = n;
            }
        }
        return result;
    }

    public void oder(TreeNode root){
        if(root == null){
            return;
        }
        res.get(0).add(root.val);
        oder(root.left);
        res.get(1).add(root.val);
        oder(root.right);
        res.get(2).add(root.val);
        return;
    }
}
