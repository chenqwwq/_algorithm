package top.chenqwwq.leetcode.archive.lcof2._92;

/**
 * @author chenbingxin
 * @date 2021/12/22
 **/
public class Solution {
	public int minFlipsMonoIncr(String s) {
		final int n = s.length();
		int c0 = 0, c1 = 0;
		for (char c : s.toCharArray()) {
			c1 = Math.min(c1, c0) + '1' - c;
			c0 = c0 + c - '0';
		}
		return Math.min(c0, c1);
	}
}