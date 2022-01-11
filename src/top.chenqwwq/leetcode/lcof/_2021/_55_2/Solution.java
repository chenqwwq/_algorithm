package top.chenqwwq.leetcode.lcof._2021._55_2;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chen
 * @date 2021-07-09
 **/
public class Solution {
	public boolean isBalanced(TreeNode root) {
		return getDeep(root) != -1;
	}

	public int getDeep(TreeNode node) {
		if (node == null) {
			return 0;
		}
		final int left = getDeep(node.left);
		if (left == -1) {
			return -1;
		}
		final int right = getDeep(node.right);
		if (right == -1) {
			return -1;
		}
		return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
	}
}