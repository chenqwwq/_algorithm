package top.chenqwwq.leetcode.contest.weekly._255._3;

/**
 * @author chen
 * @date 2021/8/22
 **/
public class Solution {
	public int minimizeTheDifference(int[][] mat, int target) {
		final int rows = mat.length, cols = mat[0].length, max = rows * 70;
		boolean[] dp = new boolean[max + 1];
		for (int j = 0; j < cols; j++) {
			dp[mat[0][j]] = true;
		}
		for (int i = 1; i < rows; i++) {
			for (int k = i * 70; k >= 0; k--) {
				if (!dp[k]) {
					continue;
				}
				for (int j = 0; j < cols; j++) {
					dp[k + mat[i][j]] = true;
				}
				dp[k] = false;
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= max; i++) {
			if (dp[i]) {
				ans = Math.min(ans, Math.abs(target - i));
			}
		}
		return ans;
	}

}