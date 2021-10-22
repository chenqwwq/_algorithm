package top.chenqwwq.leetcode.daily._20211021;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021-10-21
 **/
public class Solution {
	public int[] plusOne(int[] digits) {
		final int n = digits.length;
		boolean carry = false;
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				carry = false;
				break;
			} else {
				digits[i] = 0;
				carry = true;
			}
		}
		if (carry) {
			final int[] ans = new int[n+1];
			ans[0] = 1;
			System.arraycopy(digits, 0, ans, 1, n);
			return ans;
		}
		return digits;
	}
}