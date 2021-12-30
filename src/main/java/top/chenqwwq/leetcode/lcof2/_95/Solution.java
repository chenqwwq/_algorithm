package top.chenqwwq.leetcode.lcof2._95;

/**
 * @author chenbingxin
 * @date 2021/12/30
 **/
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        final int n = text1.length(), m = text2.length();
        if (n == 0 || m == 0) {
            return 0;
        }
        // dp[i] 表示 text1 的匹配数
        final char[] t1 = text1.toCharArray();
        final char[] t2 = text2.toCharArray();
        final int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (t1[i - 1] == t2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}