package top.chenqwwq.leetcode.archive.$20200418.by_topics.dynamic_programming;

/**
 * @author chen
 * @date 2021-06-28
 **/
public class Solution {
	// # 表示石头
	public long dp(char[][] board) {
		final int rows = board.length, cols = board[0].length;
		int[][] dp = new int[rows][cols];

		// 左上角[0,0]确定没有石头
		dp[0][0] = 1;
		for (int i = 1; i < cols; i++) {
			if (board[0][i] == '#') {
				dp[0][i] = 0;
				continue;
			}
			dp[0][i] = dp[0][i - 1];
		}
		for (int i = 1; i < rows; i++) {
			if (board[i][0] == '#') {
				dp[i][0] = 0;
				continue;
			}
			dp[i][0] = dp[i - 1][0];
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (board[i][j] == '#') {
					dp[i][j] = 0;
					continue;
				}
				// 每一个点都可以从左边或者上边到
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[rows - 1][cols - 1];
	}


}
