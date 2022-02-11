package top.chenqwwq.leetcode.daily._20210714;

import java.util.Arrays;

/**
 * 1818. Minimum Absolute Sum Difference
 * You are given two positive integer arrays nums1 and nums2, both of length n.
 * <p>
 * The absolute sum difference of arrays nums1 and nums2 is defined as the sum of |nums1[i] - nums2[i]| for each 0 <= i < n (0-indexed).
 * <p>
 * You can replace at most one element of nums1 with any other element in nums1 to minimize the absolute sum difference.
 * <p>
 * Return the minimum absolute sum difference after replacing at most one element in the array nums1. Since the answer may be large, return it modulo 109 + 7.
 * <p>
 * |x| is defined as:
 * <p>
 * x if x >= 0, or
 * -x if x < 0.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,7,5], nums2 = [2,3,5]
 * Output: 3
 * Explanation: There are two possible optimal solutions:
 * - Replace the second element with the first: [1,7,5] => [1,1,5], or
 * - Replace the second element with the third: [1,7,5] => [1,5,5].
 * Both will yield an absolute sum difference of |1-2| + (|1-3| or |5-3|) + |5-5| = 3.
 * Example 2:
 * <p>
 * Input: nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * Output: 0
 * Explanation: nums1 is equal to nums2 so no replacement is needed. This will result in an
 * absolute sum difference of 0.
 * Example 3:
 * <p>
 * Input: nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * Output: 20
 * Explanation: Replace the first element with the second: [1,10,4,4,2,7] => [10,10,4,4,2,7].
 * This yields an absolute sum difference of |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 105
 * 1 <= nums1[i], nums2[i] <= 105
 *
 * @author chen
 * @date 2021-07-14
 **/
public class Solution {

	private int mod = (int) 1e9 + 7;

	public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
		// 因为可能存在 nums1 中没有替换元素的情况，所以无法直接找到最大的差值替换
		final int n = nums1.length;
		final int[] search = new int[n];
		System.arraycopy(nums1, 0, search, 0, n);
		Arrays.sort(search);

		long ans = 0, max = 0;
		for (int i = 0; i < n; i++) {
			int diff = Math.abs(nums1[i] - nums2[i]);
			ans = (ans + diff) % mod;
			final int idx = bsLess(search, nums2[i]);
			max = Math.max(max, diff - Math.min(idx < 0 ? Integer.MAX_VALUE : nums2[i] - search[idx], idx + 1 < n ? search[idx + 1] - nums2[i] : Integer.MAX_VALUE));
		}
		return (int) ((ans - max + mod) % mod);
	}

	/**
	 * 找到第一个比 target 小的数
	 */
	public int bsLess(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		if (nums[right] < target) {
			return right;
		}
		while (left <= right) {
			int mid = (right + left) >> 1;
			if (target == nums[mid]) {
				return mid;
			} else if (target < nums[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}
}





















































