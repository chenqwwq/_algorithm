package top.chenqwwq.leetcode.contest.biweek._128._1;

/**
 * @author chenqwwq
 * @date 2024/4/14
 **/
public class Solution {
    public int scoreOfString(String s) {
        final int n = s.length();
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return ans;
    }
}