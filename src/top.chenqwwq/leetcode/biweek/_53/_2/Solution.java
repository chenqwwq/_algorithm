package top.chenqwwq.leetcode.biweek._53._2;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/5/29
 **/
public class Solution {
	public int minPairSum(int[] nums) {
		final int len = nums.length;
		Arrays.sort(nums);

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < len >> 1; i++) {
			ans = Math.max(ans, nums[i] + nums[len - i - 1]);
		}
		return ans;
	}
}