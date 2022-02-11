package top.chenqwwq.leetcode.topic.backtrack._10;

/**
 * 10. Regular Expression Matching
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where:
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * @author chen
 * @date 2021/3/28
 **/
public class Solution {
    public boolean isMatch(String s, String p) {
        // s 是真实串，p 是模式串

        if (p.isEmpty()) {
            return s.isEmpty();
        }

        // 首字母是否匹配
        final boolean match = !s.isEmpty() && (s.charAt(0) == (p.charAt(0)) || p.charAt(0) == '.');
        if (match) {
            if (p.length() == 1) {
                return s.length() == 1;
            }
            if (p.charAt(1) != '*') {
                return isMatch(s.substring(1), p.substring(1));
            }
            // 考虑后面是*  aaa a*a
            return isMatch(s.substring(1), p) || isMatch(s, p.substring(2)) || isMatch(s.substring(1), p.substring(2));
        } else if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2));
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("", "c*c*"));
        System.out.println(new Solution().isMatch("aa", "a"));
        System.out.println(new Solution().isMatch("aa", "a*"));
        System.out.println(new Solution().isMatch("ab", ".*"));
        System.out.println(new Solution().isMatch("aab", "c*a*b*"));
        System.out.println(new Solution().isMatch("mississippi", "mis*is*p*."));
    }
}
