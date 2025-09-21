package top.chenqwwq.leetcode.daily._2023._20230713;

/**
 * @author 沽酒
 * @since 2023/07/13
 */
public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        final int n = matrix.length;
        int[][] dp = new int[2][n];
        int flag = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = -1; k <= 1; k++) {
                    int y = j + k;
                    if (y < 0 || y >= n) continue;
                    min = Math.min(dp[flag][y], min);
                }
                dp[flag ^ 1][j] = min + matrix[i][j];
            }
            flag ^= 1;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++){
            min = Math.min(min,dp[flag][i]);
        }
        return min;
    }
}