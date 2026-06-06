package top.chenqwwq.leetcode.daily._2021._20210810;

/**
 * 413. Arithmetic Slices
 * An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * <p>
 * For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
 * Given an integer array nums, return the number of arithmetic subarrays of nums.
 * <p>
 * A subarray is a contiguous subsequence of the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
 * Example 2:
 * <p>
 * Input: nums = [1]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 *
 * @author chen
 * @date 2021-08-10
 **/
public class Solution {
	public int numberOfArithmeticSlices(int[] nums) {
		final int n = nums.length;
		int dp = 0, ans = 0;

		for (int i = 2; i < n; i++) {
			if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
				ans += (++dp);
				continue;
			}
			dp = 0;
		}

		return ans;
	}
}