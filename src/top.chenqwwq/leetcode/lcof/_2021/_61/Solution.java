package top.chenqwwq.leetcode.lcof._2021._61;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021-07-09
 **/
public class Solution {
	public boolean isStraight(int[] nums) {
		Arrays.sort(nums);
		int diff = 0;
		for (int i = 1; i < 5; i++) {
			if (nums[i - 1] != 0) {
				if (nums[i] == nums[i - 1]) {
					return false;
				}
				diff += nums[i] - nums[i - 1];
			}
		}
		return diff <= 4;
	}
}