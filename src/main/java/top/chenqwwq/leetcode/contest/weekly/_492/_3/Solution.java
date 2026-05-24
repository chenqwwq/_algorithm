package top.chenqwwq.leetcode.contest.weekly._492._3;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/3/8
 **/
public class Solution {
    public int minOperations(String s) {
        if (s.length() == 1) return 0;
        if (s.length() == 2) return s.charAt(0) > s.charAt(1) ? -1 : 0;

        final char[] cs = s.toCharArray();
        Arrays.sort(cs);
        if (s.equals(new String(cs))) return 0;

        char min = 'z' + 1, max = 'a' - 1;
        for (char c : s.toCharArray()) {
            if (c < min) min = c;
            if (c > max) max = c;
        }

        if (min == s.charAt(0) || max == s.charAt(s.length() - 1)) return 1;
        if (max == s.charAt(0)) return 3;
        return 2;
    }
}