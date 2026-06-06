package top.chenqwwq.leetcode.daily._2025._20250305;

/**
 * @author chenqwwq
 * @date 2025/3/5
 **/
public class Solution {
    public String breakPalindrome(String palindrome) {
        final int n = palindrome.length();
        if (n < 2) return "";
        for (int i = 0; i < n / 2; i++) {
            if (palindrome.charAt(i) != 'a') {
                return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1);
            }
        }
        return palindrome.substring(0, n - 1) + 'b';
    }
}