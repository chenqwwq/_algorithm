package top.chenqwwq.leetcode.daily._20200519;

/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * @author chen
 * @date 2020-05-19
 **/
public class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length() - 1, 0);
    }

    public boolean validPalindrome(String s, int left, int right, int misMatch) {
        if (left > right) {
            return true;
        }

        if (s.charAt(left) == s.charAt(right)) {
            return validPalindrome(s, left + 1, right - 1, misMatch);
        } else {
            if (++misMatch > 1) {
                return false;
            }
            return validPalindrome(s, left + 1, right, misMatch) || validPalindrome(s, left, right - 1, misMatch);
        }
    }
}

