package top.chenqwwq.leetcode.daily._2021._20210811;

import java.util.HashMap;
import java.util.Map;

/**
 * 446. 等差数列划分 II - 子序列
 * 给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
 * <p>
 * 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
 * <p>
 * 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
 * 再例如，[1, 1, 2, 5, 7] 不是等差序列。
 * 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
 * <p>
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 题目数据保证答案是一个 32-bit 整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,4,6,8,10]
 * 输出：7
 * 解释：所有的等差子序列为：
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 * 示例 2：
 * <p>
 * 输入：nums = [7,7,7,7,7]
 * 输出：16
 * 解释：数组中的任意子序列都是等差子序列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1  <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 *
 * @author chen
 * @date 2021-08-11
 **/
public class Solution {
	public int numberOfArithmeticSlices(int[] nums) {
		final int n = nums.length;
		// dp 记录的是每个未知差值为 Long 的数列个数
		Map<Long, Integer>[] dp = new HashMap[n];
		for (int i = 0; i < n; i++) {
			dp[i] = new HashMap<>();
		}
		int ans = 0;
		// 从 1 开始计算
		for (int i = 1; i < n; i++) {
			// 遍历计算差值
			for (int j = i - 1; j >= 0; j--) {
				long diff = nums[i] - nums[j];
				final Integer cnt = dp[j].getOrDefault(diff, 0);
				ans += cnt;
				dp[i].put(diff, dp[i].getOrDefault(diff, 0) + cnt + 1);
			}
		}
		return ans;
	}
}