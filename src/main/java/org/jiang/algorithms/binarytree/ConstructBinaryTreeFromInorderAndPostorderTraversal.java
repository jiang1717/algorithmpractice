package org.jiang.algorithms.binarytree;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 */

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] postorder, int postStart, int postEnd,
                          int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootNum = postorder[postEnd];
        int inIndex = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootNum) {
                inIndex = i;
            }
        }
        TreeNode root = new TreeNode(rootNum);
        root.left = build(postorder, postStart, postStart+inIndex-inStart-1,
                inorder, inStart, inIndex-1);
        root.right = build(postorder, postStart+inIndex-inStart, postEnd-1,
                inorder, inIndex+1, inEnd);
        return root;

    }
}
