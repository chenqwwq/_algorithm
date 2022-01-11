package top.chenqwwq.leetcode.weekly._267._3;

/**
 * @author chen
 * @date 2021/11/17
 **/
public class Solution {

	private static final char EMPTY = ' ';

	public String decodeCiphertext(String encodedText, int rows) {
		if (rows == 1) {
			return encodedText;
		}
		final StringBuilder ans = new StringBuilder();
		final int cols = encodedText.length() / rows;
		int idx = 0;
		while (idx < cols) {
			for (int i = 0, j = idx; i < rows && j < cols; i++, j++) {
				ans.append(encodedText.charAt(cols * i + j));
			}
			idx++;
		}
		// 去除末尾的0
		while (ans.length() > 0 && ans.charAt(ans.length() - 1) == EMPTY) {
			ans.deleteCharAt(ans.length() - 1);
		}
		return ans.toString();
	}
}