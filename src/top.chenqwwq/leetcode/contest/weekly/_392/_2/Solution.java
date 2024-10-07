package top.chenqwwq.leetcode.contest.weekly._392._2;

/**
 * @author chenqwwq
 * @date 2024/4/7
 **/
public class Solution {
    public String getSmallestString(String s, int k) {
        final int n = s.length();
        final char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int d = Math.min(cs[i] - 'a', 'z' - cs[i] + 1);
            if (d > k) {
                cs[i] -= (char) k;
                break;
            }
            cs[i] = 'a';
            k -= d;
        }
        return new String(cs);
    }
}