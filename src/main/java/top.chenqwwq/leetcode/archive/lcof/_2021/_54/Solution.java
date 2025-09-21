package top.chenqwwq.leetcode.archive.lcof._2021._54;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数*
 *
 * @author chen
 * @date 2021-07-09
 **/
public class Solution {

	int ans = -1, cnt = 0, k = 0;

	public int kthLargest(TreeNode root, int k) {
		this.k = k;
		dfs(root);
		return ans;
	}

	public void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		dfs(root.right);
		if (++cnt == k) {
			if (ans == -1) {
				ans = root.val;
			}
			return;
		}
		dfs(root.left);
	}

}