package top.chenqwwq.leetcode.weekly._266._1;

/**
 * @author chen
 * @date 2021-11-19
 **/
public class Solution {
	private static final char[] cs = new char[]{'a', 'e', 'i', 'o', 'u'};

	public int countVowelSubstrings(String word) {
		final int n = word.length();
		if (n < 5) {
			return 0;
		}
		int ans = 0, l = 0, r = 0;
		int[] hash = new int[26];
		int cnt = 0;
		while (r < n) {
			final char c = word.charAt(r);
			if (!is(c)) {
				while (l < r) {
					final int idx = word.charAt(l) - 'a';
					if (hash[idx] > 1 && cnt == 5) {
						ans++;
					}
					if (--hash[idx] == 0) {
						cnt--;
					}
					l++;
				}
			} else {
				if (hash[c - 'a']++ == 0) {
					cnt++;
				}
				if (cnt == 5) {
					ans++;
				}
			}
			r++;
		}
		if (cnt == 5) {
			while (l < r) {
				final int idx = word.charAt(l) - 'a';
				if (--hash[idx] == 0) {
					cnt--;
				}
				if (cnt == 5) {
					ans++;
				}
				l++;
			}
		}
		return ans;
	}

	private boolean is(char c) {
		for (char i : cs) {
			if (i == c) {
				return true;
			}
		}
		return false;
	}
}