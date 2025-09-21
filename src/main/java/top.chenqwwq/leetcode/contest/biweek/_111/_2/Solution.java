package top.chenqwwq.leetcode.contest.biweek._111._2;

/**
 * @author chenqwwq
 * @date 2023/8/22
 **/
public class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        final int n = str1.length(), m = str2.length();
        if (n < m) return false;
        int i = 0, j = 0;
        while (i < n && j < m) {
            final char c1 = str1.charAt(i), c2 = str2.charAt(j);
            if (c1 == c2 || nc(c1) == c2) j++;
            i++;
        }
        return j == m;
    }

    private char nc(char c) {
        if (c == 'z') return 'a';
        return (char) (c + 1);
    }
}