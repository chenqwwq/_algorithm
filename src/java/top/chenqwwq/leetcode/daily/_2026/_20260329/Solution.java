package top.chenqwwq.leetcode.daily._2026._20260329;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/3/29
 **/
public class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return true;
        if (s1.equals(s2)) return true;
        char[] s11 = new char[]{s1.charAt(0), s1.charAt(2)}, s12 = new char[]{s1.charAt(1), s1.charAt(3)};
        char[] s21 = new char[]{s2.charAt(0), s2.charAt(2)}, s22 = new char[]{s2.charAt(1), s2.charAt(3)};
        Arrays.sort(s11);
        Arrays.sort(s12);
        Arrays.sort(s21);
        Arrays.sort(s22);

        return Arrays.equals(s21, s11) && Arrays.equals(s12, s22);
    }
}