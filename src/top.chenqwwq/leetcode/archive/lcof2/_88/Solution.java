package top.chenqwwq.leetcode.archive.lcof2._88;

/**
 * @author chenbingxin
 * @date 2021/12/9
 **/
public class Solution {
	public int minCostClimbingStairs(int[] cost) {
		final int n = cost.length;
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return cost[0];
		}
		if (n == 2) {
			return Math.min(cost[0], cost[1]);
		}
		int[] dp = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(false && false || true);
	}
}
