package top.chenqwwq.leetcode.lcof._2021._26;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chen
 * @date 2021/6/5
 **/
public class Solution {
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if (B == null) {
			return false;
		}
		return A != null && (isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
	}

	private boolean isSub(TreeNode A, TreeNode B) {
		if (B == null) {
			return true;
		}
		if (A == null || A.val != B.val) {
			return false;
		}
		return isSub(A.left, B.left) && isSub(A.right, B.right);
	}
}