package top.chenqwwq.leetcode.lcof._2021._57;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021-05-26
 **/
public class Solution {

	public int[] twoSum(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			final int sum = nums[left] + nums[right];
			if (target == sum) {
				return new int[]{nums[left], nums[right]};
			} else if (target < sum) {
				right--;
			} else {
				left++;
			}
		}
		return new int[]{};
	}
}