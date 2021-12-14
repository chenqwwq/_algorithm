package top.chenqwwq.leetcode.biweek._67._3;

import org.junit.jupiter.api.condition.DisabledOnJre;

import java.util.*;

/**
 * @author chenbingxin
 * @date 2021/12/11
 **/
public class Solution {
	public int maximumDetonation(int[][] bombs) {
		final int n = bombs.length;
		Set<Integer>[] map = new HashSet[n];
		for (int i = 0; i < n; i++) {
			map[i] = new HashSet<>();
		}

		// 不是无向图
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				if (check(bombs[i], bombs[j])) {
					map[i].add(j);
				}
			}
		}

		int ans = 1;
		boolean[] vis = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			Arrays.fill(vis, false);
			queue.clear();

			queue.add(i);
			int cnt = 1;
			vis[i] = true;
			while (!queue.isEmpty()) {
				final Integer poll = queue.poll();
				for (int num : map[poll]) {
					if (!vis[num]) {
						cnt++;
						vis[num] = true;
						queue.offer(num);
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		return ans;
	}

	private boolean check(int[] b1, int[] b2) {
		return (long) b1[2] * b1[2] >= ((long) b1[0] - b2[0]) * ((long) b1[0] - b2[0]) + ((long) b1[1] - b2[1]) * ((long) b1[1] - b2[1]);
	}

	public static void main(String[] args) {
		new Solution().maximumDetonation(new int[][]{{1, 1, 100000}, {100000, 100000, 1}});
	}
}