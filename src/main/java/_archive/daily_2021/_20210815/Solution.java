package top.chenqwwq.leetcode.daily._2021._20210815;

/**
 * 576. Out of Boundary Paths
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
 * <p>
 * Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * Output: 6
 * Example 2:
 * <p>
 * <p>
 * Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * Output: 12
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 *
 * @author chen
 * @date 2021/8/15
 **/
public class Solution {
	private static final int MOD = (int) 1e9 + 7;

	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		final long[][][] dp = new long[m][n][maxMove + 1];
		dp[startRow][startColumn][0] = 1;


		long ans = 0;
		for (int i = 1; i <= maxMove; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					if (j > 0) dp[j][k][i] = (dp[j][k][i] + dp[j - 1][k][i - 1]) % MOD;
					if (j < m - 1) dp[j][k][i] = (dp[j][k][i] + dp[j + 1][k][i - 1]) % MOD;
					if (k > 0) dp[j][k][i] = (dp[j][k][i] + dp[j][k - 1][i - 1]) % MOD;
					if (k < n - 1) dp[j][k][i] = (dp[j][k][i] + dp[j][k + 1][i - 1]) % MOD;
					if (j == 0) ans = (ans + dp[j][k][i - 1]) % MOD;
					if (j == m - 1) ans = (ans + dp[j][k][i - 1]) % MOD;
					if (k == 0) ans = (ans + dp[j][k][i - 1]) % MOD;
					if (k == n - 1) ans = (ans + dp[j][k][i - 1]) % MOD;
				}
			}
		}
		return (int) ans;
	}
}