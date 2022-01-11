package top.chenqwwq.leetcode.lcof._2021._27;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chen
 * @date 2021/6/5
 **/
public class Solution {
	public TreeNode mirrorTree(TreeNode root) {
		if (root == null) {
			return root;
		}

		final TreeNode left = mirrorTree(root.left);
		root.left = mirrorTree(root.right);
		root.right = left;
		return root;
	}
}