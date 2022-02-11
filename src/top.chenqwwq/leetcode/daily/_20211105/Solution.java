package top.chenqwwq.leetcode.daily._20211105;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen
 * @date 2021-11-05
 **/
public class Solution {
	public int longestSubsequence(int[] arr, int difference) {
		if (arr == null) {
			return 0;
		}
		final int n = arr.length;
		if (n < 2) {
			return n;
		}

		Map<Integer, Integer> hash = new HashMap<>();
		int ans = 1;
		for (int j : arr) {
			final int len = hash.getOrDefault(j - difference, 0) + 1;
			hash.put(j, Math.max(len, hash.getOrDefault(j, 0)));
			ans = Math.max(ans, len);
		}
		return ans;
	}
}