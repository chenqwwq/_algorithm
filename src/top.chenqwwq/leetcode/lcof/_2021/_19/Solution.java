package top.chenqwwq.leetcode.lcof._2021._19;

/**
 * DFS
 *
 * @author chen
 * @date 2021/6/5
 **/
public class Solution {

	public boolean isMatch(String s, String p) {
		return isMatch(s, p, 0, 0);
	}

	public boolean isMatch(String s, String p, int i, int j) {
		// 匹配串严重超过
		if (i > s.length()) {
			return false;
		}
		// 匹配串已经结束
		if (i == s.length()) {
			// 模式串也已经结束的情况
			if (j == p.length()) {
				return true;
			}
			// 模式没结束,则必须以*结尾，且不能出现连续的字母
			int t = p.length() - 1;
			boolean pre = false, have = false;
			while (t >= j) {
				if (p.charAt(t--) != '*') {
					if (!pre) {
						return false;
					}
					pre = false;
					continue;
				}
				have = true;
				pre = true;
			}
			return have;
		}
		if (j >= p.length()) {
			return false;
		}
		// 根据下一个是不是 * 来判断
		if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
			// 当前字符不相等
			if (s.charAt(i) != p.charAt(j) && p.charAt(j) != '.') {
				return isMatch(s, p, i, j + 2);
			}
			// 当前字符相等
			for (int cnt = 1; cnt + i <= s.length(); cnt++) {
				if (s.charAt(i) != s.charAt(i + cnt - 1) && p.charAt(j) != '.') {
					break;
				}
				if (isMatch(s, p, i + cnt, j + 2)) {
					return true;
				}
			}
			return isMatch(s, p, i, j + 2);
		}
		// 下一个字符不是 *
		if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
			return isMatch(s, p, i + 1, j + 1);
		}
		return false;
	}
}