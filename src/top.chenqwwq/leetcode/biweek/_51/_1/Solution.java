package top.chenqwwq.leetcode.biweek._51._1;

import java.util.Locale;

/**
 * @author chen
 * @date 2021/5/1
 **/
public class Solution {
    public String replaceDigits(String s) {
        final char[] cs = s.toCharArray();
        for (int i = 1; i < cs.length; i += 2) {
            cs[i] = shift(cs[i - 1], cs[i]);
        }
        return new String(cs);
    }

    public char shift(char c, int x) {
        return (char) (c + x - '0');
    }
}
