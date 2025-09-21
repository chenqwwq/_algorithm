package top.chenqwwq.leetcode.contest.weekly._249._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @date 2021/7/11
 **/
public class Solution {
	public int countPalindromicSubsequence(String s) {
		final int n = s.length();
		final List<Integer>[] hash = new ArrayList[26];
		for (int i = 0; i < 26; i++) {
			hash[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			hash[s.charAt(i) - 'a'].add(i);
		}

		int ans = 0;
		for (int i = 0; i < 26; i++) {
			final List<Integer> idxs = hash[i];
			if (idxs.size() < 2) {
				continue;
			}
			int min = idxs.get(0), max = idxs.get(idxs.size() - 1);
			for (int j = 0; j < 26; j++) {
				for (int num : hash[j]) {
					if (num > min) {
						if (num < max) {
							ans++;
						}
						break;
					}
				}
			}
		}
		return ans;
	}
}