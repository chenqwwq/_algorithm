package top.chenqwwq.leetcode.weekly._256._1;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/8/29
 **/
public class Solution {
	public int minimumDifference(int[] nums, int k) {
		if (k <= 1) {
			return 0;
		}
		Arrays.sort(nums);
		final int n = nums.length;
		if (k >= n) {
			return nums[n - 1] - nums[0];
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i + k - 1 < n; i++) {
			ans = Math.min(ans, nums[i + k - 1] - nums[i]);
		}
		return ans;
	}
}
