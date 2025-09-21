package top.chenqwwq.leetcode.daily._2025._20250302;

/**
 * @author chenqwwq
 * @date 2025/3/2
 **/
public class Solution {
    public int minCut(String s) {
        final int n = s.length();
        if (n < 2) return 0;

        // dp[i][j] -> [i,j] 分割成回文子串的操作数
        final int[][] dp = new int[n][n];
        // 单个字符自成回文
        for (int i = 0; i < n; i++) dp[i][i] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                final boolean eq = s.charAt(i) == s.charAt(j);
                if (j - i == 1) {
                    dp[i][j] = eq ? 0 : 1;
                } else if (eq && dp[i + 1][j - 1] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] );
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}