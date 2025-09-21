package top.chenqwwq.leetcode.archive.lcof2._8;

/**
 * @author chenbingxin
 * @date 2021/12/9
 **/
public class Solution {
	public int minSubArrayLen(int target, int[] nums) {
		final int n = nums.length;
		int ans = Integer.MAX_VALUE, left = 0, right = 0;
		long curr = 0;

		while (right < n) {
			curr += nums[right++];
			while (curr >= target) {
				ans = Math.min(ans, right - left);
				curr -= nums[left++];
			}
		}
		return ans == Integer.MAX_VALUE ? 0 : ans;
	}
}