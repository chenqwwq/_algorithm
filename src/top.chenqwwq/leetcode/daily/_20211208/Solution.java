package top.chenqwwq.leetcode.daily._20211208;

import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;

/**
 * @author chenbingxin
 * @date 2021/12/8
 **/
public class Solution {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		final int n = nums.length;
		if (n < 3 * k) {
			return new int[]{};
		}

		int[] sum = new int[n + 1];
		for (int i = 0; i < n; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}

		// 滑动窗口,滑的时候维护窗口最大值
		for (int i = 3 * k; i < n; i++) {
			final int sum3 = sum[i] - sum[i - k], sum2 = sum[i - k] - sum[i - 2 * k], sum1 = sum[i - 2 * k] - sum[i - 3 * k];

		}

		return null;
	}
}