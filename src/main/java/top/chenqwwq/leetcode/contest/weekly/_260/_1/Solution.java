package top.chenqwwq.leetcode.contest.weekly._260._1;

/**
 * 5881. 增量元素之间的最大差值 显示英文描述
 * 通过的用户数156
 * 尝试过的用户数270
 * 用户总通过次数156
 * 用户总提交次数286
 * 题目难度Easy
 * 给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，请你计算 nums[j] - nums[i] 能求得的 最大差值 ，其中 0 <= i < j < n 且 nums[i] < nums[j] 。
 * <p>
 * 返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [7,1,5,4]
 * 输出：4
 * 解释：
 * 最大差值出现在 i = 1 且 j = 2 时，nums[j] - nums[i] = 5 - 1 = 4 。
 * 注意，尽管 i = 1 且 j = 0 时 ，nums[j] - nums[i] = 7 - 1 = 6 > 4 ，但 i > j 不满足题面要求，所以 6 不是有效的答案。
 * 示例 2：
 * <p>
 * 输入：nums = [9,4,3,2]
 * 输出：-1
 * 解释：
 * 不存在同时满足 i < j 和 nums[i] < nums[j] 这两个条件的 i, j 组合。
 * 示例 3：
 * <p>
 * 输入：nums = [1,5,2,10]
 * 输出：9
 * 解释：
 * 最大差值出现在 i = 0 且 j = 3 时，nums[j] - nums[i] = 10 - 1 = 9 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 2 <= n <= 1000
 * 1 <= nums[i] <= 109
 *
 * @author chen
 * @date 2021-09-26
 **/
public class Solution {
	public int maximumDifference(int[] nums) {
		final int n = nums.length;
		int max = nums[n - 1], ans = -1;
		for (int i = n - 2; i >= 0; --i) {
			if (nums[i] < max) {
				ans = Math.max(ans, max - nums[i]);
			}
			max = Math.max(nums[i], max);
		}
		return ans;
	}
}