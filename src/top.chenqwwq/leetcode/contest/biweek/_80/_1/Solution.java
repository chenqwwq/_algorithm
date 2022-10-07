package top.chenqwwq.leetcode.contest.biweek._80._1;

/**
 * @author chenqwwq
 * @date 2022/6/11
 **/
public class Solution {
    private String content = "!@#$%^&*()-+";

    public boolean strongPasswordCheckerII(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean a = false, b = false, c = false, d = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                a = true;
            } else if (Character.isLowerCase(ch)) {
                b = true;
            } else if (Character.isDigit(ch)) {
                c = true;
            } else if (content.contains("" + ch)) {
                d = true;
            }
            if (i + 1 < password.length() && ch == password.charAt(i + 1)) {
                return false;
            }
        }
        return a && b && c && d;
    }
}
