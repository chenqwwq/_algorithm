package top.chenqwwq.leetcode.daily._20210603;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 * <p>
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 *
 * @author chen
 * @date 2021-06-03
 **/
public class Solution {

	public int findMaxLength(int[] nums) {
		final int n = nums.length;
		if (n == 1) {
			return 0;
		}

		int ans = 0, sum = 0;
		Map<Integer, Integer> hash = new HashMap<>();

		// 初始数据
		hash.put(sum, 0);
		sum += (nums[0] == 0 ? -1 : 1);
		hash.put(sum, 1);

		for (int i = 1; i < n; i++) {
			sum += (nums[i] == 0 ? -1 : 1);
			if (!hash.containsKey(sum)) {
				hash.put(sum, i + 1);
			} else {
				ans = Math.max(ans, i - hash.get(sum) + 1);
			}
		}
		return ans;
	}
}