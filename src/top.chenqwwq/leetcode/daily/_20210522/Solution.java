package top.chenqwwq.leetcode.daily._20210522;

/**
 * @author chen
 * @date 2021/5/22
 **/
public class Solution {
	public boolean xorGame(int[] nums) {
		final int n = nums.length;
		if ((n & 1) == 0) {
			return true;
		}

		// 异或和
		int xor = 0;
		for (int i : nums) {
			xor ^= i;
		}
		return xor == 0;
	}
}