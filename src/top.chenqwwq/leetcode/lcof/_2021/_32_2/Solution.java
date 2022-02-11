package top.chenqwwq.leetcode.lcof._2021._32_2;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 * <p>
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 *
 * @author chen
 * @date 2021-05-26
 **/
class Solution {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		dfs(root, 0, ans);
		return ans;
	}

	private void dfs(TreeNode node, int level, List<List<Integer>> ans) {
		if (node == null) {
			return;
		}
		while (ans.size() <= level) {
			ans.add(new ArrayList<>());
		}
		ans.get(level).add(node.val);
		dfs(node.left, level + 1, ans);
		dfs(node.right, level + 1, ans);
	}
}
