package top.chenqwwq.leetcode.daily._2021._20211108;

/**
 * @author chen
 * @date 2021-11-08
 **/
public class Solution {
	public String getHint(String secret, String guess) {
		final int n = secret.length();
		int[] hash = new int[10];
		int a = 0, b = 0;
		for (int i = 0; i < n; i++) {
			final char c1 = secret.charAt(i), c2 = guess.charAt(i);
			if (c1 == c2) {
				a++;
				continue;
			}
			if (hash[c2 - '0']++ < 0) {
				b++;
			}
			if (hash[c1 - '0']-- > 0) {
				b++;
			}
		}
		return a + "A" + b + "B";
	}
}
