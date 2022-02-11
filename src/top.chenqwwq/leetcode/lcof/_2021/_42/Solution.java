package top.chenqwwq.leetcode.lcof._2021._42;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 *
 * @author chen
 * @date 2021-07-02
 **/
public class Solution {

	public int maxSubArray(int[] nums) {

		int ans = Integer.MIN_VALUE, curr = 0;
		for (int num : nums) {
			curr += num;
			ans = Math.max(Math.max(ans, curr), num);
			curr = Math.max(curr, num);
		}
		return ans;
	}

}