package top.chenqwwq.leetcode.lcof._2021._56_1;

/**
 * @author chen
 * @date 2021-05-31
 **/
public class Solution {
	public int[] singleNumbers(int[] nums) {
		int aft = 0;
		for (int num : nums) {
			aft ^= num;
		}

		int i = aft & -aft;
		int a = 0, b = 0;
		for (int num : nums) {
			if ((num & i) == i) {
				a ^= num;
			} else {
				b ^= num;
			}
		}

		return new int[]{a, b};
	}
}