package top.chenqwwq.leetcode.contest.weekly._297._2;

/**
 * @author chenqwwq
 * @date 2022/6/12
 **/
public class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];

        System.arraycopy(grid[0], 0, dp[0], 0, m);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    dp[i][j] = Math.min(dp[i][j], grid[i][j] + dp[i - 1][k] + moveCost[grid[i - 1][k]][j]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}