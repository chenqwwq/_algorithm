package top.chenqwwq.leetcode.daily._2025._20250110;

/**
 * @author chenqwwq
 * @date 2025/1/10
 **/
public class Solution {
    public long validSubstringCount(String s, String t) {
        if (s.length() < t.length()) return 0;

        final char[] sc = s.toCharArray(), tc = t.toCharArray();
        final int n = sc.length;

        // 统计 t 的所有字符hash
        final int[] hash = new int[26];
        for (char c : tc) hash[c - 'a']++;

        final int[] diff = new int[26];
        long ans = 0;
        // 滑动窗口统计
        int l = 0, r = 0;
        while (r < n) {
            // 窗口右移
            diff[sc[r++] - 'a']++;

            if (cover(diff, hash)) {
                long x = n - r + 1;
                do {
                    ans += x;
                } while (l < n && l <= r && --diff[sc[l] - 'a'] >= hash[sc[l++] - 'a']);
            }
        }

        return ans;
    }

    public boolean cover(int[] h1, int[] h2) {
        for (int i = 0; i < 26; i++) {
            if (h1[i] < h2[i]) return false;
        }
        return true;
    }
}