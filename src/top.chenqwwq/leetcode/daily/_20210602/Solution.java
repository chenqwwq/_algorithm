package top.chenqwwq.leetcode.daily._20210602;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * <p>
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * 示例 3：
 * <p>
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 *
 * @author chen
 * @date 2021-06-02
 **/
public class Solution {
	public boolean checkSubarraySum(int[] nums, int k) {
		if (nums == null || nums.length < 2) {
			return false;
		}
		final int n = nums.length;
		Map<Integer, Integer> hash = new HashMap<>();
		int pre = 0;
		hash.put(0, 0);
		for (int i = 0; i < n; i++) {
			pre += nums[i];
			final int y = pre % k;
			if (y == 0 && i > 0) {
				return true;
			}
			if (!hash.containsKey(y)) {
				hash.put(y, i + 1);
				continue;
			}
			if (i + 1 - hash.get(y) > 1) {
				return true;
			}

		}
		return false;
	}
}






















































