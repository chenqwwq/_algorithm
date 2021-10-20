package top.chenqwwq.leetcode.daily._20211020;

/**
 * @author chen
 * @date 2021-10-20
 **/
public class Solution {
	public int minMoves(int[] nums) {
		int min = nums[0], ans = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < min) {
				ans += (min - nums[i]) * i;
				min = nums[i];
			} else {
				ans += nums[i] - min;
			}
		}
		return ans;
	}
}