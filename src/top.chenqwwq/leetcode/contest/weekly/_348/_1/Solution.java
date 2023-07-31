package top.chenqwwq.leetcode.contest.weekly._348._1;

/**
 * @author chenqwwq
 * @date 2023/6/4
 **/
public class Solution {
    public int minimizedStringLength(String s) {
        final int n = s.length();
        int[] hash = new int[26];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (hash[s.charAt(i) - 'a']++ == 0) ans++;
        }
        return ans;
    }
}