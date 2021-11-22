package top.chenqwwq.leetcode.week._266._2;

/**
 * @author chen
 * @date 2021-11-19
 **/
public class Solution {
	public long countVowels(String word) {
		final int n = word.length();
		int dp = is(word.charAt(0)) ? 1 : 0;
		int sum = dp;
		for (int i = 1; i < n; i++) {
			if (is(word.charAt(i))) {
				dp += (i + 1);
			}
			sum += dp;
		}
		return sum;
	}

	private boolean is(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}