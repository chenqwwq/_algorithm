package top.chenqwwq.leetcode.topic.dichotomy._29;

/**
 * @author chen
 * @date 2021-09-15
 **/
public class Solution {
	public int divide(int dividend, int divisor) {
		final boolean neg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
		if (dividend < 0) {
			dividend = ~dividend + 1;
		}
		if (divisor < 0) {
			divisor = ~divisor + 1;
		}

		// 找到 m 使得 m * divisor  < dividend < (m + 1) * divisor
		long left = 0, right = dividend;
		while (left < right) {
			final long mid = left + right + 1 >> 1;
			if (mul(divisor, mid) <= dividend) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		if (neg) {
			left = ~left + 1;
		}
		if (left < Integer.MIN_VALUE || left > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return (int) left;
	}

	public long mul(long a, long b) {
		long ans = 0;
		while (b > 0) {
			if ((b & 1) == 1) {
				ans += a;
			}
			b >>= 1;
			a += 1;
		}
		return ans;
	}
}