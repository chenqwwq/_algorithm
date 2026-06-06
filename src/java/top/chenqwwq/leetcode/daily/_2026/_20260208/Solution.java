package top.chenqwwq.leetcode.daily._2026._20260208;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chenqwwq
 * @date 2026/2/8
 **/
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        final int l = get(root.left), r = get(root.right);
        return l != -1 && r != -1 && Math.abs(l - r) <= 1;
    }

    public int get(TreeNode node) {
        if (node == null) return 0;
        final int l = get(node.left), r = get(node.right);
        if (Math.abs(l - r) > 1) return -1;
        if (l == -1 || r == -1) return -1;
        return Math.max(l, r) + 1;
    }
}