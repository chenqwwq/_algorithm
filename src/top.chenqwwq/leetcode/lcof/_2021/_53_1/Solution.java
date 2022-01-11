package top.chenqwwq.leetcode.lcof._2021._53_1;

/**
 * @author chen
 * @date 2021-07-09
 **/
public class Solution {
	public int search(int[] nums, int target) {
		return find(nums, target) - find(nums, target - 1);
	}

	public int find(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (nums[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
}