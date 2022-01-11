package top.chenqwwq.leetcode.weekly._269._2;

import java.util.Arrays;

/**
 * @author chenbingxin
 * @date 2021/11/28
 **/
public class Solution {
	public int[] getAverages(int[] nums, int k) {
		if (k == 0) {
			return nums;
		}
		final int n = nums.length;
		final long[] pre = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			pre[i] = pre[i - 1] + nums[i - 1];
		}
		// 1 2 3 4
		// 0 1 3 6 10

		final int[] ans = new int[n];
		Arrays.fill(ans, -1);
		for (int i = k; i < n - k; i++) {
			ans[i] = (int) ((pre[i + k + 1] - pre[i - k]) / (2 * k + 1));
		}
		return ans;
	}

	public static void main(String[] args) {
		new Solution().getAverages(new int[]{7,4,3,9,1,8,5,2,6},3);
	}
}