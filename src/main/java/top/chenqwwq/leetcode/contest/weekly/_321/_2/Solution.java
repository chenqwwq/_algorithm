package top.chenqwwq.leetcode.contest.weekly._321._2;

/**
 * @author chenqwwq
 * @date 2022/11/27
 **/
public class Solution {
    public int appendCharacters(String s, String t) {
        final int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return m - j;
    }
}