package top.chenqwwq.leetcode.topic.dp.pack._01._416;

/**
 * @author chen
 * @date 2021/9/10
 **/
public class Solution {
	public boolean canPartition(int[] nums) {
		// 转换成01背包的问题
		// 需要总和的一半

		final int n = nums.length;
		int total = 0;
		for (int num : nums) total += num;
		if ((total & 1) == 1) return false;

		total >>= 1;
		boolean[] dp = new boolean[total + 1];
		dp[0] = true;
		for (int num : nums) {
			// 只能从大到小，小到大会影响
			for (int j = total; j >= num; --j) {
				dp[j] |= dp[j - num];
			}
		}
		return dp[total];
	}
}