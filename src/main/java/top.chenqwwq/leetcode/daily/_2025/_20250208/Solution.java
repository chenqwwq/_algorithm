package top.chenqwwq.leetcode.daily._2025._20250208;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2025/2/8
 **/
public class Solution {
    public int uniquePathsWithObstacles(int[][] g) {
        if (g[0][0] == 1) return 0;
        final int n = g.length, m = g[0].length;
        final int[] dp = new int[m];
        for (int i = 0; i < m && g[0][i] == 0; i++) dp[i] = 1;
        for (int i = 1; i < n; i++) {
            dp[0] = dp[0] == 0 ? 0 : 1 - g[i][0];
            for (int j = 1; j < m; j++) {
                dp[j] = g[i][j] == 1 ? 0 : dp[j] + dp[j - 1];
            }
        }

        return dp[m - 1];
    }
}