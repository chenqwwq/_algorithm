package top.chenqwwq.leetcode.weekly._298._4;

/**
 * @author chenqwwq
 * @date 2022/6/19
 **/
public class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        // 表示 i 高，j 宽的木板可以卖多少
        int[][] dp = new int[m + 1][n + 1];
        for (int[] p : prices) {
            dp[p[0]][p[1]] = p[2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int[] p : prices) {
                    int a = i - p[0], b = j - p[1];
                    if (a < 0 || b < 0) {
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i][j], dp[a][b]);
                }
            }
        }
        return dp[m][n];
    }
}