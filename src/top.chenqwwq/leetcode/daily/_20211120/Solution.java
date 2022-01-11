package top.chenqwwq.leetcode.daily._20211120;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen
 * @date 2021/11/20
 **/
public class Solution {
	public int findLHS(int[] nums) {
		// 最大和最小值相差1,就只能存在两个数字
		Map<Integer, Integer> hash = new HashMap<>();
		for (int num : nums) {
			hash.put(num, hash.getOrDefault(num, 0) + 1);
		}
		int ans = 0;
		for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
			if (hash.containsKey(entry.getKey() + 1)) {
				ans = Math.max(ans, entry.getValue() + hash.get(entry.getKey() + 1));
			}
		}
		return ans;
	}
}