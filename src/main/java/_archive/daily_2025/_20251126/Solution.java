package top.chenqwwq.leetcode.daily._2025._20251126;

/**
 * @author chenqwwq
 * @date 2025/11/26
 **/
public class Solution {
    int mod = (int) 1e9 + 7;

    public int numberOfPaths(int[][] grid, int k) {
        final int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[n][m][k];
        dp[0][0][grid[0][0] % k] = 1;       // 初始

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int q = 0; q < k; q++) {
                    int v = grid[i][j] % k;
                    int mm = (q - v + k) % k;
                    if (i - 1 >= 0) dp[i][j][q] = (dp[i][j][q] + dp[i - 1][j][mm]) % mod;
                    if (j - 1 >= 0) dp[i][j][q] = (dp[i][j][q] + dp[i][j - 1][mm]) % mod;
                }
            }
        }
        return dp[n - 1][m - 1][0];
    }

}