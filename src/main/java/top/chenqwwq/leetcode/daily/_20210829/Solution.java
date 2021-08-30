package top.chenqwwq.leetcode.daily._20210829;

/**
 * @author chen
 * @date 2021/8/29
 **/
public class Solution {
	public int sumOddLengthSubarrays(int[] arr) {
		final int n = arr.length;
		final int[] pre = new int[n + 1];
		pre[0] = 0;
		for (int i = 0; i < n; i++) {
			pre[i + 1] = arr[i] + pre[i];
		}
		int ans = pre[n];

		for (int i = 3; i <= n; i += 2) {
			for (int j = 0; j <= n - i; j++) {
				ans += pre[j + i] - pre[j];
			}
		}
		return ans;
	}
}