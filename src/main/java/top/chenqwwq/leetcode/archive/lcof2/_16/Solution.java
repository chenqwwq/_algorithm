package top.chenqwwq.leetcode.archive.lcof2._16;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenbingxin
 * @date 2021/12/12
 **/
public class Solution {
	public int lengthOfLongestSubstring(String s) {
		final int n = s.length();
		if (n < 2) {
			return n;
		}
		Set<Character> set = new HashSet<>();
		int ans = 0;
		for (int i = 0, j = 0; i < n; i++) {
			if (set.contains(s.charAt(i))) {
				do {
					set.remove(s.charAt(j));
				} while (s.charAt(j++) != s.charAt(i));
			}
			set.add(s.charAt(i));
			ans = Math.max(ans, i - j + 1);
		}
		return ans;
	}
}