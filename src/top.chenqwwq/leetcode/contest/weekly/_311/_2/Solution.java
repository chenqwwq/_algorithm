package top.chenqwwq.leetcode.contest.weekly._311._2;

/**
 * @author chenqwwq
 * @date 2022/9/18
 **/
public class Solution {
    private String letter = "abcdefghijklmnopqrstuvwxyz";

    public int longestContinuousSubstring(String s) {
        final int n = s.length();
        char c = s.charAt(0);
        int cnt = 1, ans = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == c + 1) {
                c = (char) (c + 1);
                ans = Math.max(++cnt, ans);
            } else {
                c = s.charAt(i);
                cnt = 1;
            }
        }
        return ans;
    }
}
