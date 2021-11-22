package top.chenqwwq.leetcode.week._262._2;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/11/20
 **/
public class Solution {
	public int minOperations(int[][] grid, int x) {
		int n = grid.length, m = grid[0].length, total = n * m;
		final int[] nums = new int[n * m];
		for (int i = 0; i < n; i++) {
			System.arraycopy(grid[i], 0, nums, i * m, m);
		}
		Arrays.sort(nums);
		int l = 0, r = total - 1;
		int ans = 0;
		while (l < r) {
			final int diff = nums[r] - nums[l];
			if (((diff & 1) != 0 && r - l > 2 )|| diff % x != 0) {
				return -1;
			}
			ans += diff / x;
			l++;
			r--;
		}
		return ans;
	}
}