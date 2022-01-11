package top.chenqwwq.leetcode.lcof._2021._68_2;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chen
 * @date 2021-05-31
 **/
public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val == p.val || root.val == q.val) {
			return root;
		}
		final TreeNode left = lowestCommonAncestor(root.left, p, q);
		final TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		} else if (left == null) {
			return right;
		} else {
			return left;
		}
	}
}
