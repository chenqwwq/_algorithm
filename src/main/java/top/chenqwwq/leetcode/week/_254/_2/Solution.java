package top.chenqwwq.leetcode.week._254._2;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/8/15
 **/
public class Solution {
	public int[] rearrangeArray(int[] nums) {
		if (nums.length < 3) {
			return nums;
		}

		final int n = nums.length;
		Arrays.sort(nums);
		int x = 0, y = 1, z = 2;
		while (z < n) {
			if (nums[x] + nums[z] == nums[y] * 2) {
				swap(nums, y, n - 1);
				if (x > 0) {
					x--;
					y--;
					z--;
				}
			} else {
				x++;
				y++;
				z++;
			}
		}

		return nums;
	}

	private void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}