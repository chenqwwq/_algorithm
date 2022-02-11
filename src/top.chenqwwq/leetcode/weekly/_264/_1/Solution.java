package top.chenqwwq.leetcode.weekly._264._1;

/**
 * @author chen
 * @date 2021/10/24
 **/
public class Solution {
	public int countValidWords(String sentence) {
		final String[] tokens = sentence.split(" ");
		int ans = 0;
		for (String token : tokens) {
			ans += check(token.trim());
		}
		return ans;
	}

	/**
	 * 仅由小写字母、连字符和/或标点（不含数字）。
	 * 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
	 * 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
	 */
	public int check(String token) {
		if (token.length() == 0) {
			return 0;
		}
		boolean flag = false;
		final int n = token.length();
		for (int i = 0; i < n; i++) {
			final char curr = token.charAt(i);
			if (Character.isDigit(curr)) {
				return 0;
			}
			if (curr == '-') {
				if (flag) {
					return 0;
				}
				flag = true;
				if (i == 0 || i == n - 1 || !Character.isLetter(token.charAt(i - 1)) || !Character.isLetter(token.charAt(i + 1))) {
					return 0;
				}
				i++;
				continue;
			}
			if (curr == '!' || curr == '.' || curr == ',') {
				if (i != n - 1) {
					return 0;
				}
			}
		}
		return 1;
	}
}