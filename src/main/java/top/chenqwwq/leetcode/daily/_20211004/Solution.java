package top.chenqwwq.leetcode.daily._20211004;

/**
 * @author: chenqwwq
 * @date: 2021/10/4 5:02 下午
 **/
public class Solution {
	public String licenseKeyFormatting(String s, int k) {
		final int n = s.length();
		int cnt = 0;
		StringBuilder ans = new StringBuilder();
		for (int i = n - 1; i >= 0; --i) {
			char c = s.charAt(i);
			if (c == '-') {
				continue;
			}
			if (cnt == k) {
				ans.append('-');
				cnt = 0;
			}
			ans.append(c);
			cnt++;
		}

		return ans.reverse().toString().toUpperCase();
	}
}