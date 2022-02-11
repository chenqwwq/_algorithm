package top.chenqwwq.leetcode.lcof._2021._32_1;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author chen
 * @date 2021-07-14
 **/
public class Solution {
	public int[] levelOrder(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Deque<TreeNode> deque = new ArrayDeque<>();
		deque.offer(root);
		List<Integer> temp = new ArrayList<>();
		while (!deque.isEmpty()) {
			final TreeNode pop = deque.pop();
			temp.add(pop.val);
			if (pop.left != null) {
				deque.addLast(pop.left);
			}
			if (pop.right != null) {
				deque.addLast(pop.right);
			}
		}
		int[] ans = new int[temp.size()];
		for (int i = 0; i < temp.size(); i++) {
			ans[i] = temp.get(i);
		}
		return ans;
	}
}