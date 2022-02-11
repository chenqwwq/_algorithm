package top.chenqwwq.leetcode.biweek._53._1;

/**
 * @author chen
 * @date 2021/5/29
 **/
public class Solution {
	public int countGoodSubstrings(String s) {
		if (s == null || s.length() < 3) {
			return 0;
		}
		int[] hash = new int[26];
		int ans = 0, cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i >= 3) {
				final int idx = s.charAt(i - 3) - 'a';
				if (--hash[idx] == 0) {
					cnt--;
				}
			}
			if (++hash[s.charAt(i) - 'a'] == 1) {
				if (++cnt == 3) {
					ans++;
				}
			}
		}
		return ans;
	}
}