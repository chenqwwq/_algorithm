package top.chenqwwq.leetcode.daily._2026._20260215;

/**
 * @author chenqwwq
 * @date 2026/2/15
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        final int n = a.length(), m = b.length();
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = n - 1, j = m - 1; i >= 0 || j >= 0; i--, j--) {
            int a1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int b1 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = a1 + b1 + carry;
            carry = sum / 2;
            ans.insert(0, (sum % 2));
        }
        return (carry != 0 ? "1" : "") + ans;
    }
}