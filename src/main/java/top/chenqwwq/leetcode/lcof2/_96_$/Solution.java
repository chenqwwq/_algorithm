package top.chenqwwq.leetcode.lcof2._96_$;

/**
 * @author chenbingxin
 * @date 2021/12/31
 **/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        final int n = s3.length(), m1 = s1.length(), m2 = s2.length();
        if (Math.abs(m1 - m2) > 1 || m1 + m2 != n) {
            return false;
        }
        final boolean[][] dp = new boolean[m1 + 1][m2 + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m1; i++) {
            for (int j = 0; j <= m2; j++) {
                if (i - 1 >= 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i - 1][j];
                }
                if (j - 1 >= 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        return dp[m1][m2];
    }
}