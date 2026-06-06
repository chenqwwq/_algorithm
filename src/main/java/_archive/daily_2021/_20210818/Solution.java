package top.chenqwwq.leetcode.daily._2021._20210818;

/**
 * 552. Student Attendance Record II
 * An attendance record for a student can be represented as a string where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:
 * <p>
 * 'A': Absent.
 * 'L': Late.
 * 'P': Present.
 * Any student is eligible for an attendance award if they meet both of the following criteria:
 * <p>
 * The student was absent ('A') for strictly fewer than 2 days total.
 * The student was never late ('L') for 3 or more consecutive days.
 * Given an integer n, return the number of possible attendance records of length n that make a student eligible for an attendance award. The answer may be very large, so return it modulo 109 + 7.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 8
 * Explanation: There are 8 records with length 2 that are eligible for an award:
 * "PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * Only "AA" is not eligible because there are 2 absences (there need to be fewer than 2).
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: 3
 * Example 3:
 * <p>
 * Input: n = 10101
 * Output: 183236316
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 105
 *
 * @author chen
 * @date 2021-08-18
 **/
public class Solution {
	private final int mod = (int) 1e9 + 7;
	int[][][] memo;

	public int checkRecord(int n) {
		this.memo = new int[n + 1][2][3];
		return dfs(n, 0, 0);
	}

	public int dfs(int c, int ac, int bc) {
		if (c <= 0) {
			return 1;
		}

		if (memo[c][ac][bc] != 0) {
			return memo[c][ac][bc];
		}

		int ans = 0;
		if (bc < 2) {
			ans = (ans + dfs(c - 1, ac, bc + 1)) % mod;
		}
		if (ac < 1) {
			ans = (ans + dfs(c - 1, 1, 0)) % mod;
		}
		return memo[c][ac][bc] = (ans + dfs(c - 1, ac, 0)) % mod;
	}
}