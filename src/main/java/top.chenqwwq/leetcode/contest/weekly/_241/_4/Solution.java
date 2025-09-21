package top.chenqwwq.leetcode.contest.weekly._241._4;

/**
 * @author chen
 * @date 2021/5/16
 **/
public class Solution {

	public int rearrangeSticks(int n, int k) {
		long[][] dp = new long[n + 1][n + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i][j] = (dp[i][j] + dp[i - 1][j] * (n - i)) % 1000000007;
				dp[i][j + 1] = (dp[i][j + 1] + dp[i - 1][j]) % 1000000007;
			}
		}
		return (int) dp[n][k];
	}

	public static void main(String[] args) {
		final Solution solution = new Solution();
		for (int i = 4; i < 10; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.printf("%d ", solution.rearrangeSticks(i, j));
			}
			System.out.println();
		}
	}
}