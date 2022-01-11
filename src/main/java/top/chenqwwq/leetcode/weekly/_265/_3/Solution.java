package top.chenqwwq.leetcode.weekly._265._3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author chen
 * @date 2021-11-01
 **/
public class Solution {

	interface Op {
		int op(int i, int j);
	}

	Op[] ops = new Op[]{Integer::sum, (i, j) -> i - j, (i, j) -> i ^ j};

	public int minimumOperations(int[] nums, int start, int goal) {
		final Set<Integer> exists = new HashSet<>();
		final Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		exists.add(start);
		int ans = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				final Integer curr = queue.poll();
				for (int num : nums) {
					for (Op op : ops) {
						final int res = op.op(curr, num);
						if (res == goal) {
							return ans;
						}
						if (res < 0 || res > 1000 || exists.contains(res)) {
							continue;
						}
						queue.offer(res);
						exists.add(res);
					}
				}
			}
			ans++;
		}
		return -1;
	}
}