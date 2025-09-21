package top.chenqwwq.leetcode.daily._2021._20210805;

import java.util.*;

/**
 * 802. Find Eventual Safe States
 * We start at some node in a directed graph, and every turn, we walk along a directed edge of the graph. If we reach a terminal node (that is, it has no outgoing directed edges), we stop.
 * <p>
 * We define a starting node to be safe if we must eventually walk to a terminal node. More specifically, there is a natural number k, so that we must have stopped at a terminal node in less than k steps for any choice of where to walk.
 * <p>
 * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 * <p>
 * The directed graph has n nodes with labels from 0 to n - 1, where n is the length of graph. The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph, going from node i to node j.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Illustration of graph
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Explanation: The given graph is shown above.
 * Example 2:
 * <p>
 * Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * Output: [4]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == graph.length
 * 1 <= n <= 104
 * 0 <= graph[i].length <= n
 * graph[i] is sorted in a strictly increasing order.
 * The graph may contain self-loops.
 * The number of edges in the graph will be in the range [1, 4 * 104].
 *
 * @author chen
 * @date 2021-08-05
 **/
public class Solution {
	public List<Integer> eventualSafeNodes(int[][] graph) {
		// 反向拓扑排序
		final int n = graph.length;
		// 连接到 i 的节点
		Set<Integer>[] pic = new HashSet[n];
		// 出度
		int[] out = new int[n];
		for (int i = 0; i < n; i++) {
			pic[i] = new HashSet<>();
		}
		for (int i = 0; i < n; i++) {
			final int[] gra = graph[i];
			for (int p : gra) {
				pic[p].add(i);
			}
			out[i] = gra.length;
		}
		List<Integer> ans = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (out[i] == 0) {
				queue.add(i);
				ans.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				final Integer poll = queue.poll();
				for (int j : pic[poll]) {
					if (--out[j] == 0) {
						queue.add(j);
						ans.add(j);
					}
				}
			}
		}
		ans.sort(Comparator.comparingInt(o -> o));
		return ans;
	}
}