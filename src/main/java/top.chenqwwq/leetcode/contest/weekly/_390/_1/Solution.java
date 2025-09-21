package top.chenqwwq.leetcode.contest.weekly._390._1;

/**
 * @author chenqwwq
 * @date 2024/3/24
 **/
public class Solution {
    public int maximumLengthSubstring(String s) {
        // 滑动窗口
        final int n = s.length();
        int l = 0, r = -1;
        int[] hash = new int[26];
        int ans = 0;
        while (++r < n) {
            final int i = s.charAt(r) - 'a';
            if (++hash[i] > 2) {
                while (s.charAt(l) != s.charAt(r)){
                    hash[s.charAt(l++) - 'a']--;
                }
                hash[i]--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}