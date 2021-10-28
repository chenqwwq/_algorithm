package top.chenqwwq.leetcode.lccup2._104;

/**
 * @author chen
 * @date 2021/10/27
 **/
public class Solution {
	public int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target + 1];
		for (int num : nums) {
			if (num > 0 && num <= target) {
				dp[num]++;
			}
		}
		for (int i = 1; i <= target; i++) {
			for (int num : nums) {
				final int diff = i - num;
				if (diff <= 0 || diff > target || dp[diff] == 0) {
					continue;
				}
				dp[i] += dp[diff];
			}
		}
		return dp[target];
	}
}