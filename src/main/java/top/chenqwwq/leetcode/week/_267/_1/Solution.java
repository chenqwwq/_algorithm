package top.chenqwwq.leetcode.week._267._1;

/**
 * @author chen
 * @date 2021/11/17
 **/
public class Solution {
	public int timeRequiredToBuy(int[] tickets, int k) {
		final int n = tickets.length;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += Math.min(tickets[k] - (i <= k ? 0 : 1),tickets[i]);
		}
		return ans;
	}
}