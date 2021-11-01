package top.chenqwwq.leetcode.week._265._1;

/**
 * @author chen
 * @date 2021-11-01
 **/
public class Solution {
	public int smallestEqual(int[] nums) {
		final int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (i % 10 == nums[i]) {
				return i;
			}
		}
		return -1;
	}
}