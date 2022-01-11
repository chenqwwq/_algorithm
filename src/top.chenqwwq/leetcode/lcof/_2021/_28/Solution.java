package top.chenqwwq.leetcode.lcof._2021._28;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chen
 * @date 2021/6/6
 **/
public class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSym(root.left, root.right);
	}

	public boolean isSym(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null || left.val != right.val) {
			return false;
		}
		return isSym(left.left, right.right) && isSym(left.right, right.left);
	}
}