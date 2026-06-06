package top.chenqwwq.leetcode.daily._2021._20210804;

import java.util.Arrays;

/**
 * 611. Valid Triangle Number
 * Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,3,4]
 * Output: 3
 * Explanation: Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Example 2:
 * <p>
 * Input: nums = [4,2,3,4]
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 *
 * @author chen
 * @date 2021-08-04
 **/
public class Solution {
	public int triangleNumber(int[] nums) {
		final int n = nums.length;
		if (n < 3) {
			return 0;
		}
		Arrays.sort(nums);
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int target = nums[i] + nums[j];
				final int t = bs(nums, target, j, n - 1);
				ans += t - j - 1;
			}
		}

		return ans;
	}

	public int bs(int[] nums, int target, int l, int r) {
		// 查找 nums 中第一个大于 num 的数的下标
		while (l <= r) {
			final int mid = (l + r) >> 1;
			if (nums[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return l;
	}
}