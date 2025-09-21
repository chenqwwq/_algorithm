package top.chenqwwq.leetcode.daily._2024._20240220;

import top.chenqwwq.leetcode.common.TreeNode;

import javax.swing.undo.AbstractUndoableEdit;

/**
 * @author chenqwwq
 * @date 2024/2/20
 **/
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2) {
        if (r1 == l1) return new TreeNode(preorder[l1]);
        // 找到中序遍历的头节点
        int val = preorder[l1], i = l2;
        while (i <= r2 && inorder[i] != val) {
            i++;
        }
        // 左子树大小为 ls
        int s = i - l2;
        TreeNode root = new TreeNode(val);
        root.left = buildTree(preorder, inorder, l1 + 1, l1 + s, l2, i - 1);
        root.right = buildTree(preorder, inorder, l1 + s + 1, r1, i + 1, r2);
        return root;
    }
}
