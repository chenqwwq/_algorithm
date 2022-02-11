package top.chenqwwq.leetcode.daily._20210701;

import java.util.*;

/**
 * @author chen
 * @date 2021/7/1
 **/
public class Solution {
	public int numWays(int n, int[][] relation, int k) {
		Map<Integer, Set<Integer>> hash = new HashMap<>();
		for (int[] r : relation) {
			final Set<Integer> orDefault = hash.getOrDefault(r[0], new HashSet<>());
			orDefault.add(r[1]);
			hash.put(r[0], orDefault);
		}
		if (n == 1) {
			return 0;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		while (k-- > 0 && !queue.isEmpty()) {
			final int size = queue.size();
			for (int q = 0; q < size; q++) {
				final Integer poll = queue.poll();
				final Set<Integer> integers = hash.get(poll);
				if (integers == null || integers.isEmpty()) {
					continue;
				}
				for (int p : integers) {
					queue.add(p);
				}
			}
		}

		int ans = 0;
		for (int i : queue) {
			if (i == n - 1) {
				ans++;
			}
		}
		return ans;
	}
}