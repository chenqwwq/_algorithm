package top.chenqwwq.leetcode.lcof._2021._7;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chen
 * @date 2021-05-26
 **/
public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, inorder, 0, 0, inorder.length - 1);
	}

	public TreeNode build(int[] preorder, int[] inorder, int ps, int is, int ie) {
		if (is > ie) {
			return null;
		}
		if (is == ie) {
			return new TreeNode(inorder[is]);
		}
		TreeNode root = new TreeNode(preorder[ps]);
		for (int i = is; i <= ie; i++) {
			if (preorder[ps] == inorder[i]) {
				root.left = build(preorder, inorder, ps + 1, is, i - 1);
				root.right = build(preorder, inorder, ps + i - is + 1, i + 1, ie);
			}
		}
		return root;
	}
}