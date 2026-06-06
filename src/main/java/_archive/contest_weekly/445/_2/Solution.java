package top.chenqwwq.leetcode.contest.weekly._445._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2025/4/13
 **/
public class Solution {
    public String smallestPalindrome(String s) {
        final int n = s.length();
        final char[] cs = s.toCharArray();
        Arrays.sort(cs);
        char mid = '#';
        char[] ans = new char[n];
        for (int i = 0, j = 0; i < n; ) {
            if (i >= n - 1 || cs[i] != cs[i + 1]) {
                mid = cs[i];
                i++;
            } else {
                ans[j] = cs[i];
                ans[n - j - 1] = cs[i];
                i += 2;
                j++;
            }
        }
        if (mid != '#') ans[n >> 1] = mid;
        return new String(ans);
    }
}