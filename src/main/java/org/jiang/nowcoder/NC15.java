package org.jiang.nowcoder;

import java.util.ArrayList;

public class NC15 {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        ArrayList<Integer> level = new ArrayList<>();
        ArrayList<Integer> subres = new ArrayList<>();
        if(root != null){

            list.add(root);
            int l = 0;
            level.add(l);
            while(!list.isEmpty()){
                if (level.get(0) > l) {
                    res.add(new ArrayList<>(subres));
                    subres.clear();
                }
                TreeNode node = list.remove(0);
                l = level.remove(0);
                subres.add(node.val);
                if (node.left != null) {
                    list.add(node.left);
                    level.add(l + 1);
                }
                if (node.right != null) {
                    list.add(node.right);
                    level.add(l + 1);
                }
            }
        }
        if(!subres.isEmpty()){
            res.add(new ArrayList<>(subres));
        }
        return res;
    }
}
