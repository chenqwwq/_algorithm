package top.chenqwwq.leetcode.daily._20200707;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author chen
 * @date 2020-07-07
 **/
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        final int nextSum = sum - root.val;
        if (root.left == null && root.right == null) {
            return nextSum == 0;
        }

        return hasPathSum(root.left, nextSum) || hasPathSum(root.right, nextSum);
    }
}
