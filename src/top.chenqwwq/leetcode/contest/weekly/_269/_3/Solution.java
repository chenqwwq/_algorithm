package top.chenqwwq.leetcode.contest.weekly._269._3;

import java.util.Arrays;

/**
 * @author chenbingxin
 * @date 2021/11
 **/
public class Solution {
	public int minimumDeletions(int[] nums) {
		final int n = nums.length;
		if (n < 3) {
			return n;
		}
		int ai = 0, ii = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (nums[i] >= max) {
				max = nums[i];
				ai = i;
			}
			if (nums[i] <= min) {
				min = nums[i];
				ii = i;
			}
		}

		final int r = Math.max(ai, ii), l = Math.min(ai, ii);
		return min(r + 1, n - l, l + 1 + n - r);
	}

	private int min(int... nums) {
		System.out.println(Arrays.toString(nums));
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			min = Math.min(num, min);
		}
		return min;
	}
}