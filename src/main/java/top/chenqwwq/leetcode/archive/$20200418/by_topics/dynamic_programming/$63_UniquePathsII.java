package top.chenqwwq.leetcode.archive.$20200418.by_topics.dynamic_programming;

/**
 * @author bingxin.chen
 * @date 2019/12/23 16:48
 */
public class $63_UniquePathsII {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            // 默认都是0
            // dp[i][j] 表示到i,j的几种途径
            int[][] dp = new int[m][n];

            for (int i = 0; i < m; i++) {
                dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : i > 0 ? dp[i - 1][0] : 1;
            }

            for (int i = 0; i < n; i++) {
                dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : i > 0 ? dp[0][i - 1] : 1;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
                }
            }

            return dp[m - 1][n - 1];
        }
    }
}
