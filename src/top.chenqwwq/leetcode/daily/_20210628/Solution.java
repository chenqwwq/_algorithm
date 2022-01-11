package top.chenqwwq.leetcode.daily._20210628;

import java.util.*;

/**
 * 815. 公交路线
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * <p>
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * <p>
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 * 示例 2：
 * <p>
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 105
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) <= 105
 * 0 <= routes[i][j] < 106
 * 0 <= source, target < 106
 *
 * @author chen
 * @date 2021-06-28
 **/
public class Solution {
	public int numBusesToDestination(int[][] routes, int source, int target) {
		if (source == target) {
			return 0;
		}

		final int n = routes.length;
		// 建图
		List<List<Integer>> bus = new ArrayList<>();
		// station —> bus
		Map<Integer, List<Integer>> station = new HashMap<>();
		for (int i = 0; i < n; i++) {
			List<Integer> ss = new ArrayList<>();
			for (int sta : routes[i]) {
				final List<Integer> orDefault = station.getOrDefault(sta, new ArrayList<>());
				orDefault.add(i);
				station.put(sta, orDefault);
				ss.add(sta);
			}
			bus.add(ss);
		}

		Queue<Integer> queue = new LinkedList<>();
		// 记录 bus 是否已经乘坐过
		boolean[] visit = new boolean[n];
		queue.add(source);

		int ans = 0;
		while (!queue.isEmpty()) {
			ans++;
			final int size = queue.size();
			for (int i = 0; i < size; i++) {
				final Integer poll = queue.poll();
				final List<Integer> buses = station.get(poll);
				// 所有经过该站的公交车
				for (int num : buses) {
					if (visit[num]) {
						continue;
					}
					visit[num] = true;
					for (int sta : bus.get(num)) {
						if (sta == target) {
							return ans;
						}
						queue.offer(sta);
					}
				}
			}
		}
		return -1;
	}
}


















