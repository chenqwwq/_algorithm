package top.chenqwwq.leetcode.contest.weekly._252._1;

/**
 * @author chen
 * @date 2021/8/1
 **/
public class Solution {

	int mod = (int) (1e9 + 7);

	public int countSpecialSubsequences(int[] nums) {
		final int n = nums.length;
		long[] dp = new long[]{0, 0, 0};

		for (int num : nums) {
			switch (num) {
				case 0:
					dp[0] = (dp[0] * 2 + 1) % mod;
					break;
				case 1:
					dp[1] = (dp[1] * 2 + dp[0]) % mod;
					break;
				case 2:
					dp[2] = (dp[2] * 2 + dp[1]) % mod;
					break;
				default:
					break;
			}
		}
		return (int) dp[2];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().countSpecialSubsequences(new int[]{0, 1, 2, 0, 1, 2}));
	}
}