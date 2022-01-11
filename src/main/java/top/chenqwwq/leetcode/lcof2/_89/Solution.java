package top.chenqwwq.leetcode.lcof2._89;

/**
 * @author chenbingxin
 * @date 2021/12/10
 **/
public class Solution {
	public int rob(int[] nums) {
		final int n = nums.length;
		int[][] dp = new int[n][2];
		dp[0][0] = 0;
		dp[0][1] = nums[0];

		for (int i = 1; i < n; i++) {
			// 不偷
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			// 偷
			dp[i][1] = dp[i - 1][0] + nums[i];
		}
		return Math.max(dp[n-1][0],dp[n-1][1]);
	}
}