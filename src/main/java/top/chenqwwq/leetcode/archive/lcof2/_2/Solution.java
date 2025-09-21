package top.chenqwwq.leetcode.archive.lcof2._2;

/**
 * @author chenbingxin
 * @date 2021/12/3
 **/
public class Solution {
	public String addBinary(String a, String b) {
		final int na = a.length(), nb = b.length();
		StringBuilder ans = new StringBuilder();
		int i = 1, carry = 0, a1, b1, sum;
		while (na >= i || nb >= i) {
			a1 = na >= i ? a.charAt(na - i) - '0' : 0;
			b1 = nb >= i ? b.charAt(nb - i) - '0' : 0;
			sum = a1 + b1 + carry;
			ans.insert(0, sum % 2);
			carry = sum / 2;
			i++;
		}
		if (carry != 0) {
			ans.insert(0, carry);
		}
		return ans.toString();
	}
}
