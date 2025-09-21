package top.chenqwwq.leetcode.contest.weekly._258._4;

import java.util.*;

/**
 * @author chen
 * @date 2021/9/12
 **/
public class Solution {
	Map<Integer, List<Integer>> tree = new HashMap<>();
	int[] nums;

	public int[] smallestMissingValueSubtree(int[] parents, int[] _nums) {
		nums = _nums;
		for (int i = 1; i < parents.length; i++) {
			final List<Integer> orDefault = tree.getOrDefault(parents[i], new ArrayList<>());
			orDefault.add(i);
			tree.put(parents[i], orDefault);
		}
		int[] ans = new int[nums.length];
		dfs(ans, 0, new PriorityQueue<>());
		return ans;
	}

	public int dfs(int[] ans, int curr, PriorityQueue<Integer> queue) {
		int start = 1;
		if (tree.containsKey(curr)) {
			for (int i : tree.get(curr)) {
				PriorityQueue<Integer> remain = new PriorityQueue<>();
				start = Math.max(start, dfs(ans, i, remain));
				queue.addAll(remain);
			}
		}

		queue.add(nums[curr]);
		while (!queue.isEmpty() && start == queue.peek()) {
			start = queue.poll() + 1;
		}
		ans[curr] = start;
		return start;
	}
}