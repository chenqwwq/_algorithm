package top.chenqwwq.leetcode.contest.biweek._61._4;

/**
 * @author chen
 * @date 2021/9/18
 **/
public class Solution {
	public int countKDifference(int[] nums, int k) {
		int ans = 0;
		final int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (Math.abs(nums[i] - nums[j]) == k) {
					ans++;
				}
			}
		}
		return ans;
	}
}