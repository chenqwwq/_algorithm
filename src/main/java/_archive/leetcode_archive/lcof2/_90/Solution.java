package top.chenqwwq.leetcode.archive.lcof2._90;

/**
 * @author chenbingxin
 * @date 2021/12/21
 **/
public class Solution {
	public int rob(int[] nums) {
		final int n = nums.length;
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return nums[0];
		}

		return Math.max(dp(nums, 0, n - 1), dp(nums, 1, n));
	}

	public int dp(int[] nums, int l, int r) {
		int pre = 0, curr = 0, tmp;
		for (int i = l; i < r; i++) {
			tmp = curr;
			curr = Math.max(pre + nums[i], curr);
			pre = tmp;
		}
		return curr;
	}
}