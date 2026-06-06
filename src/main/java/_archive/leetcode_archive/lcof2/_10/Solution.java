package top.chenqwwq.leetcode.archive.lcof2._10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenbingxin
 * @date 2021/12/10
 **/
public class Solution {
	public int subarraySum(int[] nums, int k) {
		final int n = nums.length;
		// 存在负值，无法使用滑动窗口
		Map<Integer, Integer> hash = new HashMap<>();
		hash.put(0, 1);
		int sum = 0, ans = 0;
		for (int num : nums) {
			sum += num;
			ans += hash.getOrDefault(sum - k, 0);
			hash.put(sum, hash.getOrDefault(sum, 0) + 1);
		}
		return ans;
	}
}
