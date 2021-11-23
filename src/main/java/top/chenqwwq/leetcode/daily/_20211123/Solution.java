package top.chenqwwq.leetcode.daily._20211123;

/**
 * @author chen
 * @date 2021-11-23
 **/
public class Solution {
	public boolean buddyStrings(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}
		final int n = s.length();
		int[] hash1 = new int[26], hash2 = new int[26];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			final char a = s.charAt(i), b = goal.charAt(i);
			hash1[a - 'a']++;
			hash2[b - 'a']++;
			if (a != b) {
				if (++cnt > 2) {
					return false;
				}
			}
		}
		boolean cc = false;
		for (int i = 0; i < 26; i++) {
			if (hash1[i] != hash2[i]) {
				return false;
			}
			if (hash1[i] > 1) {
				cc = true;
			}
		}
		return cnt == 2 || (cnt == 0 && cc);
	}
}