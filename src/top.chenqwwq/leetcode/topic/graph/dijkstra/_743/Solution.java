package top.chenqwwq.leetcode.topic.graph.dijkstra._743;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 743. Network Delay Time
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * <p>
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * Example 2:
 * <p>
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * Example 3:
 * <p>
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
 *
 * @author chen
 * @date 2021-08-06
 **/
public class Solution {
	private static final int INF = 0x3f3f3f3f;

	public int networkDelayTime(int[][] times, int n, int k) {
		// 预处理图数据
		List<int[]>[] edges = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int[] time : times) {
			edges[time[0]].add(new int[]{time[1], time[2]});
		}

		// 朴素 Dijkstra 算法
		// dic 表示各个节点到 k 的距离
		int[] dic = new int[n + 1];
		// vis 表示是否访问过
		boolean[] vis = new boolean[n + 1];
		Arrays.fill(dic, INF);

		dic[k] = 0;
		vis[k] = true;
		for (int[] i : edges[k]) {
			dic[i[0]] = i[1];
		}


		for (int i = 1; i < n; i++) {
			int min = -1;
			// 找到未遍历过的路径最小的节点
			for (int j = 1; j <= n; j++) {
				if (!vis[j] && (min == -1 || dic[min] > dic[j])) {
					min = j;
				}
			}
			vis[min] = true;
			// 更新距离
			for (int[] edge : edges[min])
				dic[edge[0]] = Math.min(dic[edge[0]], dic[min] + edge[1]);
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans = Math.max(ans, dic[i]);
		}

		return ans == INF ? -1 : ans;
	}
}