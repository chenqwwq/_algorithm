package top.chenqwwq.leetcode.contest.weekly._247._1;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/6/27
 **/
public class Solution {
	public int maxProductDifference(int[] nums) {
		final int n = nums.length;
		Arrays.sort(nums);
		return (int) (((long) nums[n - 1] * nums[n - 2]) - ((long) nums[0] * nums[1]));
	}
}