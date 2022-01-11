package top.chenqwwq.leetcode.biweek._55._1;

/**
 * @author chen
 * @date 2021/6/26
 **/
public class Solution {
	public boolean canBeIncreasing(int[] nums) {
		if (nums.length == 2) {
			return true;
		}
		if (nums.length == 3) {
			return nums[0] < nums[1] || nums[0] < nums[2] || nums[1] < nums[2];
		}
		if (isOk(nums, 0)) {
			return true;
		}
		int idx = 1;
		while (idx < nums.length) {
			if (nums[idx - 1] >= nums[idx]) {
				// 要不删除左边，要不删除右边
				return ((idx - 2 < 0 || nums[idx - 2] < nums[idx]) && isOk(nums, idx)) || ((idx + 1 >= nums.length || nums[idx - 1] < nums[idx + 1]) && isOk(nums, idx + 1));
			}
			idx++;
		}
		return false;
	}

	public boolean isOk(int[] nums, int k) {
		for (int i = k; i < nums.length - 1; i++) {
			if (nums[i] >= nums[i + 1]) {
				return false;
			}
		}
		return true;
	}
}
