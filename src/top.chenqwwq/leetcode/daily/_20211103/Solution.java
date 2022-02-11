package top.chenqwwq.leetcode.daily._20211103;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * [1,4,3,1,3,2],
 * [3,2,1,3,2,4],
 * [2,3,3,2,3,1]
 *
 * @author chen
 * @date 2021/11/3
 **/
public class Solution {
	int[] cx = new int[]{1, -1, 0, 0}, cy = new int[]{0, 0, 1, -1};
	int n, m;

	public int trapRainWater(int[][] heightMap) {
		n = heightMap.length;
		m = heightMap[0].length;
		if (n <= 2 || m <= 2) {
			return 0;
		}
		boolean[][] vis = new boolean[n][m];
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		for (int i = 0; i < m; i++) {
			queue.offer(new int[]{0, i, heightMap[0][i]});
			vis[0][i] = true;
			queue.offer(new int[]{n - 1, i, heightMap[n - 1][i]});
			vis[n - 1][i] = true;
		}
		for (int i = 1; i < n - 1; i++) {
			queue.offer(new int[]{i, 0, heightMap[i][0]});
			vis[i][0] = true;
			queue.offer(new int[]{i, m - 1, heightMap[i][m - 1]});
			vis[i][m - 1] = true;
		}

		int ans = 0;
		while (!queue.isEmpty()) {
			final int[] curr = queue.poll();
			for (int i = 0; i < 4; i++) {
				final int x = curr[0] + cx[i], y = curr[1] + cy[i];
				if (check(x, y) && !vis[x][y]) {
					vis[x][y] = true;
					if (heightMap[x][y] < curr[2]) {
						ans += curr[2] - heightMap[x][y];
						queue.offer(new int[]{x, y, curr[2]});
					} else {
						queue.offer(new int[]{x, y, heightMap[x][y]});
					}
				}
			}
		}
		return ans;
	}

	private boolean check(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}