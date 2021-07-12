package org.jiang.algorithms.binarytree;

import com.sun.source.tree.Tree;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 * 示例 1:
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * 示例 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }
        int rootNum = preorder[preStart];
        int inIndex = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootNum) {
                inIndex = i;
            }
        }
        //Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        TreeNode root = new TreeNode(rootNum);
        root.left = build(preorder, preStart + 1, preStart + inIndex - inStart,
                                inorder, inStart, inIndex - 1);
        root.right = build(preorder, preStart + inIndex - inStart + 1, preEnd,
                                inorder, inIndex + 1, inEnd);
        return root;
    }
}
