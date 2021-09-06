package top.chenqwwq.leetcode.biweek._60._2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chen
 * @date 2021/9/4
 **/
public class Solution {
	public int[][] findFarmland(int[][] land) {
		final int n = land.length, m = land[0].length;
		boolean[][] visit = new boolean[n][m];
		List<int[]> res = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visit[i][j] || land[i][j] == 0) {
					continue;
				}
				visit[i][j] = true;
				int x = i, y = j;
				while (y + 1 < m && land[i][y + 1] == 1) {
					visit[x][++y] = true;
				}
				while (x + 1 < n && land[x + 1][j] == 1) {
					Arrays.fill(visit[++x], j, y + 1, true);
				}

				res.add(new int[]{i, j, x, y});
			}
		}

		int[][] ans = new int[res.size()][4];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}
}