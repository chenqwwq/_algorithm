package top.chenqwwq.leetcode.topic.dp.pack._01._494;

/**
 * @author chen
 * @date 2021/9/11
 **/
public class Solution {
	public int findTargetSumWays(int[] nums, int target) {
		final int n = nums.length;
		int[] sum = new int[n];
		sum[0] = nums[0];
		for (int i = 1; i < n; i++) {
			sum[i] = sum[i - 1] + nums[i];
		}

		if (sum[n - 1] < target) {
			return 0;
		}

		final int total = sum[n - 1], max = (sum[n - 1] << 1) + 1;
		int[][] dp = new int[n][max];

		dp[0][total + nums[0]]++;
		dp[0][total - nums[0]]++;
		// 全量背包
		for (int i = 1; i < n; i++) {
			int num = nums[i];
			for (int j = -sum[i]; j <= sum[i]; j++) {
				if (total + j - num >=0){
					dp[i][total + j] += dp[i - 1][total + j - num];
				}
				if (total + j + num < max) {
					dp[i][total + j] += dp[i - 1][total + j + num];
				}
			}
		}

		return dp[n - 1][target + total];
	}
}
