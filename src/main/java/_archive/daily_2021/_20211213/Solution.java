package top.chenqwwq.leetcode.daily._2021._20211213;

/**
 * @author chenbingxin
 * @date 2021/12/13
 **/
public class Solution {
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		final int n = grid.length, m = grid[0].length;
		int[] vertical = new int[n], horizontal = new int[m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				vertical[i] = Math.max(vertical[i], grid[i][j]);
				horizontal[j] = Math.max(horizontal[j], grid[i][j]);
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ans += Math.min(vertical[i], horizontal[j]) - grid[i][j];
			}
		}
		return ans;
	}
}