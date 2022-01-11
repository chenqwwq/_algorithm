package top.chenqwwq.leetcode.lcof._2021._21;

/**
 * @author chen
 * @date 2021/6/5
 **/
public class Solution {
	public int[] exchange(int[] nums) {
		final int n = nums.length;
		int even = n - 1, cur = 0;
		while (cur < even) {
			if ((nums[cur] & 1) == 0) {
				swap(nums, cur, even--);
			} else {
				cur++;
			}
		}
		return nums;
	}

	private void swap(int[] nums, int i, int j) {
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}
}