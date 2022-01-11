package top.chenqwwq.leetcode.daily._20200522;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * @author chen
 * @date 2020-05-22
 **/
public class Solution {
    /**
     * 先序遍历的下标
     */
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || inorder.length == 0 || inorder.length != preorder.length) {
            return null;
        }

        return null;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preS, int preE, int inS, int inE) {
        if (preS < preE || inS < inE) {
            return null;
        }


        TreeNode root = new TreeNode(preorder[0]);
        return null;
    }
}
