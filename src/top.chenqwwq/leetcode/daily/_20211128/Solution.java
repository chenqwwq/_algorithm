package top.chenqwwq.leetcode.daily._20211128;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenbingxin
 * @date 2021/11/28
 **/
public class Solution {
	public List<Integer> findAnagrams(String s, String p) {
		final int n = p.length(), m = s.length();
		if (m < n) {
			return new ArrayList<>();
		}

		// 仅包含小写
		int target = 0;
		final int[] hash = new int[26];
		for (char c : p.toCharArray()) {
			if (hash[c - 'a']++ == 0) {
				target++;
			}
		}
		List<Integer> ans = new ArrayList<>();
		// start
		// match count
		int mc = 0, left = 0, right = 0;
		while (right < m) {
			final char c = s.charAt(right++);
			if (--hash[c - 'a'] == 0) {
				mc++;
			}
			if (mc == target) {
				ans.add(left);
			}
			if (right - left >= n) {
				final char ch = s.charAt(left++);
				if (hash[ch - 'a']++ == 0) {
					mc--;
				}
			}
		}

		return ans;
	}
}