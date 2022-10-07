package top.chenqwwq.leetcode.contest.biweek._62._1;

/**
 * @author: chenqwwq
 * @date: 2021/10/4 8:17 下午
 **/
public class Solution {
	public int[][] construct2DArray(int[] original, int m, int n) {
		final int a = original.length;
		if (a > (m * n)) {
			return new int[][]{};
		}
		final int[][] ans = new int[m][n];
		int idx = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				ans[i][j] = original[idx++];
			}
		}
		return ans;
	}
}