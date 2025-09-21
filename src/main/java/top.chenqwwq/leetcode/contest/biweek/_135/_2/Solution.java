package top.chenqwwq.leetcode.contest.biweek._135._2;

/**
 * @author chenqwwq
 * @date 2024/7/21
 **/
public class Solution {
    public int minimumLength(String s) {
        final int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (hash[i] > 2) {
                hash[i] = (hash[i] & 1) == 1 ? 1 : 2;
            }
            ans += hash[i];
        }
        return ans;
    }
}