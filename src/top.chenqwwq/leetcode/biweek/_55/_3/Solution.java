package top.chenqwwq.leetcode.biweek._55._3;

/**
 * @author chen
 * @date 2021/6/26
 **/
public class Solution {
	public long maxAlternatingSum(int[] nums) {
		final int n = nums.length;
		if (n == 1) {
			return nums[0];
		}
		long sum1 = 0, sum2 = 0;
		boolean even = true;
		for (int i = 0; i < n; i++) {
			if (even) {
				if (i == n - 1) {
					sum1 += nums[i];
				} else if (nums[i] > nums[i + 1]) {
					sum1 += nums[i];
					even = false;
				}
			} else {
				if (i != n - 1 && nums[i] < nums[i + 1]) {
					sum2 += nums[i];
					even = true;
				}
			}
		}
		return sum1 - sum2;
	}

	public static void main(String[] args) {
		new Solution().maxAlternatingSum(new int[]{3, 1, 2});
	}
}
