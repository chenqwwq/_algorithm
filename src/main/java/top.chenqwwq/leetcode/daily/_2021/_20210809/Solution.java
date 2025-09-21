package top.chenqwwq.leetcode.daily._2021._20210809;

import java.util.Arrays;

/**
 * 313. Super Ugly Number
 * A super ugly number is a positive integer whose prime factors are in the array primes.
 * <p>
 * Given an integer n and an array of integers primes, return the nth super ugly number.
 * <p>
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly numbers given primes = [2,7,13,19].
 * Example 2:
 * <p>
 * Input: n = 1, primes = [2,3,5]
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are in the array primes = [2,3,5].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 106
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * primes[i] is guaranteed to be a prime number.
 * All the values of primes are unique and sorted in ascending order.
 *
 * @author chen
 * @date 2021-08-09
 **/
public class Solution {
	public int nthSuperUglyNumber(int n, int[] primes) {
		final int ln = primes.length;
		int[] fn = new int[ln], dp = new int[n], nums = new int[ln];
		Arrays.fill(fn, 0);
		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < ln; j++) {
				min = Math.min(min, nums[j] = primes[j] * dp[fn[j]]);
			}
			dp[i] = min;

			for (int q = 0; q < ln; q++) {
				if (dp[i] == nums[q]) {
					fn[q]++;
				}
			}
		}
		return dp[n - 1];
	}
}