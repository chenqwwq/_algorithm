package top.chenqwwq.leetcode.biweek._55._2;


/**
 * @author chen
 * @date 2021/6/26
 **/
public class Solution {
	public String removeOccurrences(String s, String part) {
		StringBuilder stringBuilder = new StringBuilder(s);
		final int length = part.length();
		while (s.indexOf(part) != -1) {
			final int i = s.indexOf(part);
			stringBuilder.delete(i, i + length);
			s = stringBuilder.toString();
		}
		return stringBuilder.toString();
	}
}