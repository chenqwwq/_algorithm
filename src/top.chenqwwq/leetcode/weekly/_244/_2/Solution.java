package top.chenqwwq.leetcode.weekly._244._2;

import java.util.*;

/**
 * @author chen
 * @date 2021/6/6
 **/
public class Solution {
	public int reductionOperations(int[] nums) {
		Map<Integer, Integer> hash = new HashMap<>();
		for (int num : nums) {
			hash.put(num, hash.getOrDefault(num, 0) + 1);
		}
		final ArrayList<Integer> keyList = new ArrayList<>(hash.keySet());
		keyList.sort((o1, o2) -> Integer.compare(o2, o1));
		int ans = 0, cur = 0;
		for (int i = 0; i < keyList.size() - 1; i++) {
			final Integer nu = hash.get(keyList.get(i));
			cur += nu;
			ans += cur;
		}
		return ans;
	}
}