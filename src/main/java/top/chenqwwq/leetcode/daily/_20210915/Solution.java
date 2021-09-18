package top.chenqwwq.leetcode.daily._20210915;

/**
 * @author chen
 * @date 2021-09-15
 **/
public class Solution {
	int[] nums;

	public int findPeakElement(int[] _nums) {
		if (_nums.length == 1) {
			return 0;
		}
		nums = _nums;
		// O(logN) 考虑二分
		final int n = nums.length;
		int left = 0, right = n - 1;
		while (left < right) {
			final int mid = (left + right + 1) >> 1;
			if (get(mid) > get(mid - 1) && get(mid) > get(mid + 1)) {
				return mid;
			}
			if (get(mid) > get(mid - 1)) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		return left >= n ? -1 : left;
	}

	public int get(int i) {
		if (i < 0 || i >= nums.length) {
			return Integer.MIN_VALUE;
		}
		return nums[i];
	}
}
