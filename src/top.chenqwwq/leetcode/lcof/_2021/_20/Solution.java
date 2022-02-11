package top.chenqwwq.leetcode.lcof._2021._20;

/**
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 数值（按顺序）可以分成以下几个部分：
 * <p>
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
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
 * 部分数值列举如下：
 * <p>
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 * <p>
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
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
 * 输入：s = "    .1  "
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
 *
 * @author chen
 * @date 2021/6/5
 **/
public class Solution {
	public boolean isNumber(String s) {
		s = s.trim();
		final int n = s.length();
		for (int i = 1; i < n; i++) {
			if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
				return (isDecimalOrInteger(s, 0, i - 1)) && isInteger(s, i + 1, n - 1, false);
			}
		}
		return isDecimalOrInteger(s, 0, s.length() - 1);
	}

	public boolean isInteger(String s, int l, int r, boolean canNull) {
		return isInteger(s, l, r, canNull, true);
	}

	public boolean isInteger(String s, int l, int r, boolean canNull, boolean canHaveSign) {
		if (l < s.length() && (s.charAt(l) == '+' || s.charAt(l) == '-')) {
			if (!canHaveSign) {
				return false;
			}
			l++;
		}
		if (l > r) {
			return canNull;
		}
		while (l <= r) {
			if (!Character.isDigit(s.charAt(l++))) {
				return false;
			}
		}
		return true;
	}

	public boolean isDecimalOrInteger(String s, int l, int r) {
		// 是否存在.
		/**
		 *
		 * 小数（按顺序）可以分成以下几个部分：
		 * <p>
		 * （可选）一个符号字符（'+' 或 '-'）
		 * 下述格式之一：
		 * 至少一位数字，后面跟着一个点 '.'
		 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
		 * 一个点 '.' ，后面跟着至少一位数字
		 */
		for (int i = l; i <= r; i++) {
			if (s.charAt(i) == '.') {
				return (isInteger(s, l, i - 1, false, true) && isInteger(s, i + 1, r, true, false))
						|| (isInteger(s, l, i - 1, true, true) && isInteger(s, i + 1, r, false, false));
			}
		}
		return isInteger(s, l, r, false);
	}
}





















