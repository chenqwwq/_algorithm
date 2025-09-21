package top.chenqwwq.leetcode.contest.weekly._260._2;

/**
 * @author chen
 * @date 2021-09-26
 **/
public class Solution {
	public long gridGame(int[][] grid) {
		final int n = grid[0].length;
		long[][] presum = new long[2][n + 1];
		for (int i = 0; i < n; i++) {
			presum[0][i + 1] = presum[0][i] + grid[0][i];
			presum[1][i + 1] = presum[1][i] + grid[1][i];
		}
		long ans = Long.MAX_VALUE;
		// 什么时候向下
		for (int i = 0; i < n; i++) {
			ans = Math.min(ans, Math.max(presum[0][n] - presum[0][i + 1], presum[1][i]));
		}
		return ans;
	}
}