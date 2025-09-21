package top.chenqwwq.leetcode.contest.biweek._146._2;

/**
 * @author chenqwwq
 * @date 2024/12/21
 **/
public class Solution {
    int[][] g;
    int k;

    int mod = (int) (1e9 + 7);
    int N = 1 << 5;

    public int countPathsWithXorValue(int[][] grid, int k) {
        final int n = grid.length, m = grid[0].length;
        this.g = grid;
        this.k = k;

        // dp[i][j][k] 记录到 grid[i][j] 异或为 k 的路径数
        final long[][][] dp = new long[n][m][N];
        dp[0][0][grid[0][0]] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                final int y1 = j - 1;
                if (y1 >= 0) {
                    for (int q = 0; q < N; q++) {
                        if (dp[i][y1][q] <= 0) continue;
                        final int idx = q ^ grid[i][j];
                        dp[i][j][idx] = (dp[i][y1][q] + dp[i][j][idx]) % mod;
                    }
                }
                int x2 = i - 1;
                if (x2 >= 0) {
                    for (int q = 0; q < N; q++) {
                        if (dp[x2][j][q] <= 0) continue;
                        final int idx = q ^ grid[i][j];
                        dp[i][j][idx] = (dp[x2][j][q] + dp[i][j][idx]) % mod;
                    }
                }
            }
        }
        return (int) dp[n - 1][m - 1][k] % mod;
    }

    public static void main(String[] args) {
        new Solution().countPathsWithXorValue(new int[][]{{2, 1, 5}, {7, 10, 0}, {12, 6, 4}}, 11);
    }
}