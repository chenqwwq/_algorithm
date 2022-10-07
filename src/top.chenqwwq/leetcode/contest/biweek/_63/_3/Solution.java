package top.chenqwwq.leetcode.contest.biweek._63._3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chen
 * @date 2021-10-19
 **/
public class Solution {
	private static final int INF = 0x3F3F3F3F;

	public int networkBecomesIdle(int[][] edges, int[] patience) {
		final int n = patience.length;
		final List<Integer>[] nexts = new List[n];
		for (int i = 0; i < n; i++) {
			nexts[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			nexts[edge[0]].add(edge[1]);
			nexts[edge[1]].add(edge[0]);
		}
		final Queue<Integer> queue = new LinkedList<>();
		final boolean[] vis = new boolean[n];
		int ans = 0, depth = 0;
		queue.add(0);
		vis[0] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				final Integer poll = queue.poll();
				if (poll != 0) {
					// 计算最后一条消息发出的时间
					int time = 2 * depth % patience[poll] > 0 ? 2 * depth % patience[poll] : patience[poll];
					ans = Math.max(ans, 4 * depth - time + 1);
				}
				for (int next : nexts[poll]) {
					if (!vis[next]) {
						vis[next] = true;
						queue.offer(next);
					}
				}
			}
			depth++;
		}
		return ans;
	}
}