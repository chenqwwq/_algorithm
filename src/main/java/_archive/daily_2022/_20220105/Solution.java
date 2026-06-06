package top.chenqwwq.leetcode.daily._2022._20220105;

/**
 * @author chenbingxin
 * @date 2022/1/5
 **/
public class Solution {
    public String modifyString(String s) {
        final int n = s.length();
        if (n <= 0) {
            return s;
        }

        StringBuilder ans = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '?') {
                ans.setCharAt(i, get(ans, i - 1, i + 1));
            } else {
                ans.setCharAt(i,s.charAt(i));
            }
        }
        return ans.toString();
    }

    public char get(StringBuilder s, int a, int b) {

        for (int i = 0; i < 26; i++) {
            final char c = (char) ('a' + i);
            if ((a < 0 || c != s.charAt(a)) && (b >= s.length() || c != s.charAt(b))) {
                return c;
            }
        }
        return 'a';
    }
}
