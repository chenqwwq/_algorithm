package top.chenqwwq.leetcode.daily._20210708;

/**
 * 930. 和相同的二元子数组
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * <p>
 * 子数组 是数组的一段连续部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 *
 * @author chen
 * @date 2021-07-08
 **/
public class Solution {
	public int numSubarraysWithSum(int[] nums, int goal) {
		final int n = nums.length;
		int sum = nums[0], left = 0, right = 0, ans = 0;

		while (left < n || right < n) {
			if (sum < goal) {
				sum += nums[++right];
			} else if (sum > goal) {
				sum -= nums[left++];
			} else {
			}
		}
		return ans;
	}
}