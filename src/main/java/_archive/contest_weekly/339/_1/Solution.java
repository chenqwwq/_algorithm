package top.chenqwwq.leetcode.contest.weekly._339._1;

/**
 * @author chenqwwq
 * @date 2023/4/2
 **/
public class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        final int n = s.length();
        int ans = 0, c0 = 0, c1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (c1 != 0) {
                    c1 = c0 = 0;
                }
                c0++;
            } else {
                ans = Math.max(ans, Math.min(++c1, c0) << 1);
            }
        }
        return ans;
    }
}