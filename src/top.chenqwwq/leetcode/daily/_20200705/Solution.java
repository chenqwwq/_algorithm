package top.chenqwwq.leetcode.daily._20200705;

/**
 * 44. 通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 *
 * @author chen
 * @date 2020/7/5 下午9:35
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        final char[] sC = s.toCharArray();
        final char[] pC = p.toCharArray();
        return mainMatch(sC, pC, 0, 0);
    }

    public boolean mainMatch(char[] s, char[] p, int i, int j) {
        if (s.length == i) {
            // 空字符串匹配
            while (j < p.length && p[j] == '*') {
                j++;
            }
            return j == p.length;
        }

        int iStart = -1, jStart = -1;
        // 回溯考虑以下情况：
        // 1. 直接相等或者p[j] == '?',可以直接双+1
        // 2. s[i] != p[j] && p[j] != '*'，直接return false;
        // 3. s[i] != p[j] && p[j] == '*',
        // 检查s和p是否匹配，从i和j开始
        while (i < s.length) {

            // 第一种情况
            if (j < p.length && (s[i] == p[j] || p[j] == '?')) {
                i++;
                j++;
                continue;
            }

            // 第三种情况分开考虑
            // 1). 暂时不考虑*的匹配
            if (j < p.length && p[j] == '*') {
                iStart = i;
                jStart = j++;
                continue;
            }

            // 不考虑*不行，此时就多匹配一位
            if (iStart != -1) {
                i = ++iStart;
                j = jStart + 1;
                continue;
            }


            return false;
        }

        if (i == s.length && j < p.length) {
            while (j < p.length && p[j] == '*') {
                j++;
            }

            return j == p.length;
        }

        return true;
    }
}
