package top.chenqwwq.leetcode.contest.weekly._259._2;

/**
 * @author chen
 * @date 2021/9/19
 **/
public class Solution {
	public int sumOfBeauties(int[] nums) {
		final int n = nums.length;
		int[] pre = new int[n], sub = new int[n];
		pre[0] = nums[0];
		sub[n - 1] = nums[n - 1];
		for (int i = 1; i < n; i++) {
			pre[i] = Math.max(pre[i - 1], nums[i]);
			sub[n - i - 1] = Math.min(sub[n - i], nums[n - i - 1]);
		}
		int ans = 0;
		for (int i = 1; i <= n - 2; i++) {
			if (pre[i - 1] < nums[i] && nums[i] < sub[i + 1]) {
				ans += 2;
			} else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
				ans += 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		new Solution().sumOfBeauties(new int[]{1, 2, 3});
	}
}