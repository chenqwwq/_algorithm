package top.chenqwwq.leetcode.daily._2024._20240221;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chenqwwq
 * @date 2024/2/21
 **/
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] in, int[] post, int l1, int r1, int l2, int r2) {
        if (r2 == l2) return new TreeNode(post[r2]);
        int val = post[r2], i = l1;
        while (i <= r1 && in[i] != val) i++;

        // 左子树大小
        final int ls = i - l1;
        final TreeNode root = new TreeNode(val);
        if (l1 <= i - 1) root.left = buildTree(in, post, l1, i - 1, l2, l2 + ls - 1);
        if (i + 1 <= r1) root.right = buildTree(in, post, i + 1, r1, l2 + ls , r2 - 1);
        return root;
    }
}