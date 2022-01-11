package top.chenqwwq.leetcode.weekly._242._1;

/**
 * @author chen
 * @date 2021/5/23
 **/
public class Solution {
	public boolean checkZeroOnes(String s) {
		int[] c = new int[2];
		final char[] chars = s.toCharArray();
		int cnt = 1;
		char mode = chars[0];
		for (int i = 1; i < s.length(); i++) {
			if (chars[i] == mode) {
				cnt++;
			} else {
				final int idx = mode - '0';
				c[idx] = Math.max(c[idx], cnt);
				mode = mode == '0' ? '1' : '0';
				cnt = 1;
			}
		}
		final int idx = mode - '0';
		c[idx] = Math.max(c[idx], cnt);

		return c[1] > c[0];
	}
}