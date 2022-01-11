package top.chenqwwq.leetcode.lcof2._15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenbingxin
 * @date 2021/12/12
 **/
public class Solution {
	public List<Integer> findAnagrams(String s, String p) {

		final int n = s.length(), m = p.length();
		final int[] h1 = new int[26], h2 = new int[26];

		for (int i = 0; i < m; i++) {
			h2[p.charAt(i) - 'a']++;
		}

		List<Integer> ans = new ArrayList<>();
		for (int l = 0, r = 0; r < n; r++) {
			h1[s.charAt(r) - 'a']++;
			while (r - l + 1 > m) {
				h1[s.charAt(l++) - 'a']--;
			}
			if (Arrays.equals(h1, h2)) {
				ans.add(l);
			}
		}
		return ans;
	}
}