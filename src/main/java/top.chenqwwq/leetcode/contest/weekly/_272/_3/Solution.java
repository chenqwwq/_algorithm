package top.chenqwwq.leetcode.contest.weekly._272._3;

import java.util.Arrays;

/**
 * @author chenbingxin
 * @date 2021/12/19
 **/
public class Solution {
	public long getDescentPeriods(int[] prices) {
		final int n = prices.length;
		final int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = 1; i < n; i++) {
			if (prices[i] + 1 == prices[i - 1]) {
				dp[i] += dp[i - 1];
			}
		}

		long sum = 0;
		for (int i : dp) {
			sum += i;
		}
		return sum;
	}
}