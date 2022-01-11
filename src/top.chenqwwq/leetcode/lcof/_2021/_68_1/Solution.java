package top.chenqwwq.leetcode.lcof._2021._68_1;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chen
 * @date 2021-05-26
 **/
class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null) {
			if (root.val > p.val && root.val > q.val) {
				root = root.left;
			} else if (root.val < p.val && root.val < q.val) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}
}