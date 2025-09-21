package top.chenqwwq.leetcode.contest.weekly._248._1;

/**
 * @author chen
 * @date 2021/7/4
 **/
public class Solution {
	public int[] buildArray(int[] nums) {
		final int n = nums.length;
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			ans[i] = nums[nums[i]];
		}
		return ans;
	}
}