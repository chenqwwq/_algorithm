package top.chenqwwq.leetcode.contest.weekly._250._1;

/**
 * @author chen
 * @date 2021/7/18
 **/
public class Solution {
	public long maxPoints(int[][] points) {
		final int n = points.length, m = points[0].length;
		long[][] dp = new long[n][m];

		for (int i = 0; i < m; i++) {
			dp[0][i] = points[0][i];
		}


		for (int i = 1; i < n; i++) {
			long num = -1;
			int idx = -1;
			for (int j = 0; j < m; j++) {
				if (j <= idx) {
					dp[i][j] = num + points[i][j] - Math.abs(idx - j);
					continue;
				}
				for (int q = j; q < m; q++) {
					final int abs = Math.abs(q - j);
					long tmp = dp[i - 1][q] - abs;
					if (tmp >= num - Math.abs(j - idx)) {
						num = dp[i - 1][q];
						idx = q;
					}
				}
				dp[i][j] = num + points[i][j] - Math.abs(idx - j);
			}
		}

		long ans = Long.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			ans = Math.max(ans, dp[n - 1][i]);
		}
		return ans;
	}
}