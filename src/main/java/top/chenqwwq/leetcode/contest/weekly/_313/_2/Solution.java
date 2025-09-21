package top.chenqwwq.leetcode.contest.weekly._313._2;

/**
 * @author chenqwwq
 * @date 2022/10/10
 **/
public class Solution {
    public int maxSum(int[][] grid) {
        final int n = grid.length, m = grid[0].length;

        int[][] ps = new int[n][m];
        ps[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) ps[i][0] = ps[i - 1][0] + grid[i][0];
        for (int j = 1; j < m; j++) ps[0][j] = ps[0][j - 1] + grid[0][j];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + grid[i][j];
            }
        }
        int ans = 0;

        for (int i = 2; i < n; i++) {
            for (int j = 2; j < m; j++) {
                ans = Math.max(ans,
                        ps[i][j] - (i > 2 ? ps[i - 3][j] : 0) - (j > 2 ? ps[i][j - 3] : 0) + (i > 2 && j > 2 ? ps[i - 3][j - 3] : 0) - grid[i-1][j] - grid[i-1][j-2]);
            }
        }
        return ans;
    }
}