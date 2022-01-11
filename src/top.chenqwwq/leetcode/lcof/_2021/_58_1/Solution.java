package top.chenqwwq.leetcode.lcof._2021._58_1;

/**
 * @author chen
 * @date 2021-07-09
 **/
public class Solution {
	public String reverseWords(String s) {
		if (s == null || (s = s.trim()).length() == 0) {
			return s;
		}
		String[] str = s.split(" ");
		StringBuilder ans = new StringBuilder();
		for (int i = str.length - 1; i >= 0; i--) {
			if ("".equals(str[i])) {
				continue;
			}
			ans.append(" ").append(str[i]);
		}
		return ans.substring(1);
	}
}