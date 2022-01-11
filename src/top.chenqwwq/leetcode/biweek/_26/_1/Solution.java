package top.chenqwwq.leetcode.biweek._26._1;

/**
 * 5396. 连续字符 显示英文描述
 * 题目难度Easy
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * <p>
 * 请你返回字符串的能量。
 *
 * @author chen
 * @date 2020/5/16 下午10:43
 */
public class Solution {
    public int maxPower(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        final char[] chars = s.toCharArray();
        char c = chars[0];
        int res = 0, count = 0;

        for (char ch : chars) {
            if (c == ch) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 1;
                c = ch;
            }
        }

        return Math.max(res, count);
    }
}