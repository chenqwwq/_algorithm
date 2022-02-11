package top.chenqwwq.leetcode.daily._20210717;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * @author chen
 * @date 2021/7/17
 **/
public class Solution {
	public int maxSubArray(int[] nums) {
		final int n = nums.length;
		int pre = nums[0], ans = nums[0];
		for (int i = 1; i < n; i++) {
			pre = Math.max(pre + nums[i], nums[i]);
			ans = Math.max(ans, pre);
		}
		return ans;
	}
}