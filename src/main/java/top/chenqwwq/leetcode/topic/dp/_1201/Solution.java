package top.chenqwwq.leetcode.topic.dp._1201;

/**
 * 1201. Ugly Number III
 * An ugly number is a positive integer that is divisible by a, b, or c.
 * <p>
 * Given four integers n, a, b, and c, return the nth ugly number.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3, a = 2, b = 3, c = 5
 * Output: 4
 * Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
 * Example 2:
 * <p>
 * Input: n = 4, a = 2, b = 3, c = 4
 * Output: 6
 * Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6.
 * Example 3:
 * <p>
 * Input: n = 5, a = 2, b = 11, c = 13
 * Output: 10
 * Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10.
 * Example 4:
 * <p>
 * Input: n = 1000000000, a = 2, b = 217983653, c = 336916467
 * Output: 1999999984
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n, a, b, c <= 109
 * 1 <= a * b * c <= 1018
 * It is guaranteed that the result will be in range [1, 2 * 109].
 *
 * @author chen
 * @date 2021-08-09
 **/
public class Solution {
	public int nthUglyNumber(int n, int a, int b, int c) {
		long[] dp = new long[n + 1];
		int[] fn = {0, 0, 0};
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			long fa = dp[fn[0]] + a, fb = dp[fn[1]] * b, fc = dp[fn[2]] * c;
			final long min = min(fa, fb, fc);
			dp[i] = min;
			if (fa == min) {
				fn[0]++;
			}
			if (fb == min) {
				fn[1]++;
			}
			if (fc == min) {
				fn[2]++;
			}
		}
		return (int) dp[n];
	}

	private long min(long a, long b, long c) {
		return Long.min(a, Long.min(b, c));
	}
}