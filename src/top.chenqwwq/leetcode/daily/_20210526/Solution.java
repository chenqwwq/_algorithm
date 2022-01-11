package top.chenqwwq.leetcode.daily._20210526;


/**
 * 1190. 反转每对括号间的子串
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * <p>
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * <p>
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 * <p>
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 * <p>
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 * <p>
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 *
 * @author chen
 * @date 2021/5/26
 **/
public class Solution {
	public String reverseParentheses(String s) {
		final int n = s.length();
		char[] c = new char[n], buffer = new char[n];
		int idx = 0, bufSize = 0;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) != ')') {
				c[idx++] = s.charAt(i);
			} else {
				while (--idx >= 0 && c[idx] != '(') {
					buffer[bufSize++] = c[idx];
				}
				int curr = 0;
				while (bufSize >= 1) {
					c[idx++] = buffer[curr++];
					bufSize--;
				}
			}
		}

		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < idx; i++) {
			ans.append(c[i]);
		}
		return ans.toString();
	}
}