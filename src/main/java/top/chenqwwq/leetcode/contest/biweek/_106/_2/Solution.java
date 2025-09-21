package top.chenqwwq.leetcode.contest.biweek._106._2;

/**
 * @author chenqwwq
 * @date 2023/6/10
 **/
public class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        final int n = s.length();
        int cur = 0, ans = Math.min(1, n);
        int l = 0, r = 0;
        while (r < n) {
            while (cur < 2 && ++r < n) {
                if (s.charAt(r) == s.charAt(r - 1)) cur++;
                if (cur < 2) ans = Math.max(ans, r - l + 1);
            }
            while (cur > 1 && ++l < r) {
                if (s.charAt(l) == s.charAt(l - 1)) cur--;
            }
        }
        return ans;

    }
}