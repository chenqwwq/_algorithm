package top.chenqwwq.leetcode.daily._2021._20211110;

/**
 * @author chen
 * @date 2021-11-10
 **/
public class Solution {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		final int n = timeSeries.length;
		int ans = 0;
		for (int i = 1; i < n; i++) {
			ans += Math.min((timeSeries[i] - timeSeries[i - 1]), duration);
		}
		return ans + duration;
	}
}