package top.chenqwwq.leetcode.archive.lcof._2021._34;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 10000
 *
 * @author chen
 * @date 2021-07-21
 **/
public class Solution {
	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int target) {
		dfs(root, new ArrayList<>(), target);
		return ans;
	}

	public void dfs(TreeNode node, List<Integer> curr, int target) {
		if (node == null) {
			return;
		}
		target -= node.val;
		curr.add(node.val);
		if (target == 0 && node.left == null && node.right == null) {
			ans.add(new ArrayList<>(curr));
		} else {
			dfs(node.left, curr, target);
			dfs(node.right, curr, target);
		}
		curr.remove(curr.size() - 1);
	}
}