package top.chenqwwq.leetcode.daily._20210617;

/**
 * 65. 有效数字
 * 有效数字（按顺序）可以分成以下几个部分：
 * <p>
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分有效数字列举如下：
 * <p>
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * 部分无效数字列举如下：
 * <p>
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "0"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "e"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s = "."
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = ".1"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。
 *
 * @author chen
 * @date 2021/6/17
 **/
public class Solution {

	enum PreType {
		BEGIN,
		FU_HAO,
		E,
		DIGIT,
		DOT
	}

	public boolean isNumber(String s) {
		return dfs(s, 0, PreType.BEGIN);
	}

	private boolean hasDot = false;
	private boolean hasE = false;
	private boolean hasDigit = false;

	public boolean dfs(String s, int idx, PreType type) {
		if (idx >= s.length()) {
			return type == PreType.DIGIT || (type == PreType.DOT && hasDigit);
		}

		if (Character.isLetter(s.charAt(idx)) && s.charAt(idx) != 'e' && s.charAt(idx) != 'E' && s.charAt(idx) != '.' && s.charAt(idx) != '+' && s.charAt(idx) != '-') {
			return false;
		}

		switch (type) {
			case BEGIN:
				final char c = s.charAt(idx);
				if (c == '-' || c == '+') {
					return dfs(s, idx + 1, PreType.FU_HAO);
				}
				if (c == '.') {
					return dfs(s, idx + 1, PreType.DOT);
				}
				if (Character.isDigit(s.charAt(idx))) {
					while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
						idx++;
					}
					hasDigit = true;
					return dfs(s, idx, PreType.DIGIT);
				}
				return false;
			case E:
				hasE = true;
				// E后面只能跟着整数
				if (s.charAt(idx) == '+' || s.charAt(idx) == '-') {
					idx++;
				}
				if (idx == s.length()) {
					return false;
				}
				for (int i = idx; i < s.length(); i++) {
					if (!Character.isDigit(s.charAt(i))) {
						return false;
					}
				}
				return true;
			case FU_HAO:
				// +,- 后面可以跟着数字,或者.
				if (s.charAt(idx) == '.') {
					if (hasDot) {
						return false;
					}
					return dfs(s, idx + 1, PreType.DOT);
				}
				if (Character.isDigit(s.charAt(idx))) {
					while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
						idx++;
					}
					hasDigit = true;
					return dfs(s, idx, PreType.DIGIT);
				}
				return false;
			case DOT:
				// . 后面跟着数字
				hasDot = true;
				if (s.charAt(idx) == 'e' || s.charAt(idx) == 'E') {
					if (hasE || !hasDigit) {
						return false;
					}
					return dfs(s, idx + 1, PreType.E);
				}
				if (Character.isDigit(s.charAt(idx))) {
					while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
						idx++;
					}
					hasDigit = true;
					return dfs(s, idx, PreType.DIGIT);
				}
				return false;
			case DIGIT:
				if (s.charAt(idx) == '.') {
					if (hasDot) {
						return false;
					}
					return dfs(s, idx + 1, PreType.DOT);
				}
				if (s.charAt(idx) == '-' || s.charAt(idx) == '+') {
					return false;
				}
				if (s.charAt(idx) == 'e' || s.charAt(idx) == 'E') {
					if (hasE) {
						return false;
					}
					return dfs(s, idx + 1, PreType.E);
				}
				return false;
			default:
				return false;
		}
	}
}











