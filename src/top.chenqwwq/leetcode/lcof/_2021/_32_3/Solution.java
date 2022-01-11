package top.chenqwwq.leetcode.lcof._2021._32_3;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author chen
 * @date 2021/7/17
 **/
public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		final List<List<Integer>> ans = new ArrayList<>();
		Deque<TreeNode> nodes = new ArrayDeque<>();
		if (root == null) {
			return ans;
		}
		nodes.add(root);
		boolean flag = true;
		while (!nodes.isEmpty()) {
			final int size = nodes.size();
			List<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = flag ? nodes.pollFirst() : nodes.pollLast();
				tmp.add(node.val);
				if (flag) {
					if (node.left != null) {
						nodes.addLast(node.left);
					}
					if (node.right != null) {
						nodes.addLast(node.right);
					}
				} else {
					if (node.right != null) {
						nodes.addFirst(node.right);
					}
					if (node.left != null) {
						nodes.addFirst(node.left);
					}
				}
			}
			ans.add(tmp);
			flag = !flag;
		}
		return ans;
	}
}