package top.chenqwwq.leetcode.daily._20210925;

/**
 * @author chen
 * @date 2021/9/25
 **/
public class Solution {
	public int minDistance(String word1, String word2) {
		final int n = word1.length(), m = word2.length();
		if (n == 0 || m == 0) {
			return m ^ n;
		}
		int[][] dp = new int[n][m];
		final char c = word1.charAt(0), c2 = word2.charAt(0);
		dp[0][0] = c == c2 ? 0 : 2;
		for (int i = 1; i < m; i++) {
			dp[0][i] = min(c == word2.charAt(i) ? i : i + 2, dp[0][i - 1] + 1);
		}
		for (int i = 1; i < n; i++) {
			dp[i][0] = min(c2 == word1.charAt(i) ? i : i + 2, dp[i - 1][0] + 1);
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				final char a = word1.charAt(i), b = word2.charAt(j);
				dp[i][j] = min(a == b ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 2, dp[i - 1][j] + 1, dp[i][j - 1] + 1);
			}
		}
		return dp[n - 1][m - 1];
	}

	private int min(int a, int b) {
		return Math.min(a, b);
	}

	private int min(int a, int b, int c) {
		return min(a, min(b, c));
	}
}