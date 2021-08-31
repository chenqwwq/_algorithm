package top.chenqwwq.leetcode.daily._20210831;

/**
 * @author chen
 * @date 2021-08-31
 **/
public class Solution {
	public int[] corpFlightBookings(int[][] bookings, int n) {
		int[] diff = new int[n + 1];

		for (int[] booking : bookings) {
			diff[booking[0] - 1] += booking[2];
			diff[booking[1]] -= booking[2];
		}
		int[] ans = new int[n];
		ans[0] = diff[0];
		for (int i = 1; i < n; i++) {
			ans[i] = ans[i - 1] + diff[i];
		}
		return ans;
	}
}