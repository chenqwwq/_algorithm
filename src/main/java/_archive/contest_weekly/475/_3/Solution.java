package top.chenqwwq.leetcode.contest.weekly._475._3;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2025/11/9
 **/
public class Solution {


    private static final int INF = -0x3f3f3f3f;

    public int maxPathScore(int[][] grid, int k) {
        final int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[grid.length][grid[0].length][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }


        if (grid[0][0] == 0) dp[0][0][k] = 0;
        else if (grid[0][0] == 1) dp[0][0][k - 1] = 1;
        else if (grid[0][0] == 2) dp[0][0][k - 1] = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 从左边来
                if (j - 1 >= 0) {
                    if (grid[i][j] == 0) {   // 当前不需要消耗体力
                        for (int q = 0; q <= k; q++) {
                            dp[i][j][q] = Math.max(dp[i][j][q], dp[i][j - 1][q]);
                        }
                    } else {
                        for (int q = 0; q < k; q++) {
                            if (dp[i][j - 1][q + 1] == INF) continue;
                            dp[i][j][q] = Math.max(dp[i][j][q], dp[i][j - 1][q + 1] + grid[i][j]);
                        }
                    }
                }
                // 从上面来
                if (i - 1 >= 0) {
                    if (grid[i][j] == 0) {   // 当前不需要消耗体力
                        for (int q = 0; q <= k; q++) {
                            dp[i][j][q] = Math.max(dp[i][j][q], dp[i - 1][j][q]);
                        }
                    } else {
                        for (int q = 0; q < k; q++) {
                            if (dp[i - 1][j][q + 1] == INF) continue;
                            dp[i][j][q] = Math.max(dp[i][j][q], dp[i - 1][j][q + 1] + grid[i][j]);
                        }
                    }
                }
            }
        }

        int ans = INF;
        for (int i = 0; i < k; i++) {
            ans = Math.max(ans, dp[n - 1][m - 1][i]);
        }
        return ans == INF ? -1 : ans;
    }
}