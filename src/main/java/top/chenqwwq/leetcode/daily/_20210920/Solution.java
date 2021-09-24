package top.chenqwwq.leetcode.daily._20210920;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/9/20
 **/
public class Solution {
	public int findNumberOfLIS(int[] nums) {
		final int n = nums.length;
		int[] dp = new int[n], cnt = new int[n];
		Arrays.fill(dp, 1);
		Arrays.fill(cnt,1);
		int max = 1, ans = 1;
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					final int target = dp[j] + 1;
					if (target > dp[i]) {
						dp[i] = target;
						cnt[i] = cnt[j];
					} else if (target == dp[i]) {
						cnt[i] += cnt[j];
					}
				}
			}
			if (dp[i] > max) {
				max = dp[i];
				ans = cnt[i];
			} else if (dp[i] == max) {
				ans += cnt[i];
			}
		}
		return ans;
	}
}
