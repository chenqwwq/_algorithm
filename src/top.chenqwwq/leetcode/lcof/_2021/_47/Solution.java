package top.chenqwwq.leetcode.lcof._2021._47;

/**
 * @author chen
 * @date 2021-05-26
 **/
public class Solution {
	public int maxValue(int[][] grid) {
		final int n = grid.length, m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] += Math.max((i - 1 < 0 ? 0 : grid[i - 1][j]), (j - 1 < 0 ? 0 : grid[i][j - 1]));
			}
		}
		return grid[n - 1][m - 1];
	}
}