package top.chenqwwq.leetcode.week._253._1;

/**
 * @author chen
 * @date 2021/8/8
 **/
public class Solution {
	public boolean isPrefixString(String s, String[] words) {
		int j = 0;
		while (j < words.length) {
			if (s.startsWith(words[j])) {
				if (s.equals(words[j])) {
					return true;
				}
				s = s.substring(words[j].length());
				j++;
			} else {
				return false;
			}
		}
		return s.length() == 0;
	}
}