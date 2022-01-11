package top.chenqwwq.leetcode.lcof._2021._53_2;

/**
 * @author chen
 * @date 2021-07-09
 **/
public class Solution {
	public int missingNumber(int[] nums) {
		final int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] != i) {
				return i;
			}
		}
		return n;
	}
}