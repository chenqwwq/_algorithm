package top.chenqwwq.leetcode.weekly._256._3;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/8/29
 **/
public class Solution {

	public int minSessions(int[] tasks, int sessionTime) {
		// 状态压缩 DP
		// 事先枚举每一位状态
		final int n = tasks.length, size = 1 << n;
		final int[] sum = new int[1 << n];
		for (int i = 0; i < size; i++) {
			// 遍历每一个状态的 n 位
			for (int j = 0; j < n; j++) {
				// 该状态包含该位则加入时间
				if (((i >> j) & 1) != 0) {
					sum[i] += tasks[j];
				}
			}
		}

		int[] dp = new int[size];
		Arrays.fill(dp,n);
		// 没有任务事件自然为0
		dp[0] = 0;
		for (int i = 0; i < size; i++) {
			// (j - 1) & i
			// 逐渐抹去最后一位
			for (int j = i; j > 0; j = (j - 1) & i) {
				if (sum[j] <= sessionTime) {
					dp[i] = Math.min(dp[i - j] + 1, dp[i]);
				}
			}
		}
		return dp[size - 1];
	}
}