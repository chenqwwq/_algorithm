package top.chenqwwq.leetcode.daily._20210517;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chen
 * @date 2021/5/17
 **/
public class Solution {
	int dx = -1, dy = -1, rx = -1, ry = -1;

	public boolean isCousins(TreeNode root, int x, int y) {
		dfs(root, x, y, 0, -1);
		return dx == dy && rx != ry;
	}

	public void dfs(TreeNode root, int x, int y, int curr, int parent) {
		if (root == null || (dx != -1 && dy != -1)) {
			return;
		}
		if (root.val == x) {
			dx = curr;
			rx = parent;
			return;
		}
		if (root.val == y) {
			dy = curr;
			ry = parent;
			return;
		}
		dfs(root.left, x, y, curr + 1, root.val);
		dfs(root.right, x, y, curr + 1, root.val);
	}
}