package top.chenqwwq.leetcode.archive.lcof2._19;

/**
 * @author chenbingxin
 * @date 2021/12/13
 **/
public class Solution {
	public boolean validPalindrome(String s) {
		final int n = s.length();
		int left = 0, right = n - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return valid(s, left + 1, right) || valid(s, left, right - 1);
			}
			right--;
			left++;
		}
		return true;
	}

	public boolean valid(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}