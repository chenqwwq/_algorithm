package top.chenqwwq.leetcode.daily._2023._20230717;

/**
 * @author chenqwwq
 * @date 2023/7/17
 **/
public class Solution {
    public String addStrings(String num1, String num2) {
        final int n = num1.length(), m = num2.length();
        final StringBuilder s1 = new StringBuilder(num1).reverse(), s2 = new StringBuilder(num2).reverse();
        final StringBuilder ans = new StringBuilder();
        int i = 0, j = 0, carry = 0;
        while (i < n && j < m) {
            final int sum = s1.charAt(i++) - '0' + s2.charAt(j++) - '0' + carry;
            ans.append(sum % 10);
            carry = sum / 10;
        }

        while (i < n) {
            final int sum = s1.charAt(i++) - '0' + carry;
            ans.append(sum % 10);
            carry = sum / 10;
        }

        while (j < m) {
            final int sum = s2.charAt(j++) - '0' + carry;
            ans.append(sum % 10);
            carry = sum / 10;
        }

        if(carry != 0) ans.append(carry);
        return ans.reverse().toString();
    }
}