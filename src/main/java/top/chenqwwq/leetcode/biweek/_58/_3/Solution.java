package top.chenqwwq.leetcode.biweek._58._3;

import java.util.PriorityQueue;

/**
 * @author chen
 * @date 2021/8/7
 **/
public class Solution {
	public int minSpaceWastedKResizing(int[] nums, int k) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2[0], o1[0])));
		final int n = nums.length;
		int max = nums[0], diff = 0, total = nums[0];
		for (int i = 1; i < n; i++) {
			total += nums[i];
			if (nums[i] > max) {
				queue.offer(new int[]{diff, max, i});
				max = nums[i];
			} else {
				diff += max - nums[i];
			}
		}
		int ans = max * n - total;
		while (--k >= 0 && !queue.isEmpty()) {
			final int[] poll = queue.poll();
			ans -= poll[2] * (max - poll[1]);
			max = poll[1];
		}
		return ans;
	}
}