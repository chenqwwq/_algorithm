package top.chenqwwq.leetcode.biweek._58._1;


/**
 * @author chen
 * @date 2021/8/7
 **/
public class Solution {
	public String makeFancyString(String s) {
		final int n = s.length();
		if (n < 3) {
			return s;
		}
		StringBuilder ans = new StringBuilder();
		final char[] cs = s.toCharArray();
		char curr = cs[0];
		long cnt = 1;
		ans.append(cs[0]);
		for (int i = 1; i < n; i++) {
			if (curr == cs[i]) {
				if (++cnt < 3) {
					ans.append(cs[i]);
				}
			} else {
				curr = cs[i];
				cnt = 1;
				ans.append(cs[i]);
			}
		}
		return ans.toString();
	}
}