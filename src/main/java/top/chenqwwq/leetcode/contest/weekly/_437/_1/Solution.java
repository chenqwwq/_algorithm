package top.chenqwwq.leetcode.contest.weekly._437._1;

/**
 * @author chenqwwq
 * @date 2025/2/16
 **/
public class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        final char[] ca = s.toCharArray();
        int[] hash = new int[26];
        for (char c : ca) {
            hash[c - 'a']++;
        }
        char cur = 'A', cnt = 0;
        for (char c : ca) {
            if (c != cur) {
                if (cur != 'A' && cnt == k) {
                    return true;
                }
                cur = c;
                cnt = 1;
            } else {
                cnt++;
            }
        }
        return cur != 'A' && cnt == k;
    }
}