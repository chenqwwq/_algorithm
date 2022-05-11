package top.chenqwwq.leetcode.weekly._292._4;

/**
 * @author chenqwwq
 * @date 2022/5/8
 **/
public class Solution {
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (grid[0][0] == ')') {
            return false;
        }
        boolean[][][] dp = new boolean[n][m][201];
        int first = grid[0][0] == '(' ? 1 : -1;
        dp[0][0][100 + first] = true;
        int q = first;
        for (int i = 1; i < m; i++) {
            q += grid[0][i] == '(' ? 1 : -1;
            dp[0][i][q + 100] = q >= 0;
        }
        q = first;
        for (int i = 1; i < n; i++) {
            q += grid[i][0] == '(' ? 1 : -1;
            dp[i][0][q + 100] = q >= 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] == '(') {
                    for (int k = 101; k < 199; k++) {
                        dp[i][j][k + 1] = dp[i - 1][j][k] || dp[i][j - 1][k];
                    }
                } else {
                    for (int k = 99; k > 0; k--) {
                        dp[i][j][k - 1] = dp[i - 1][j][k] || dp[i][j - 1][k];
                    }
                }
            }
        }
        return dp[n - 1][m - 1][100];
    }

    public static void main(String[] args) {
        new Solution().hasValidPath(new char[][]{{'(', '(', '('}, {')', '(', ')'}, {'(', '(', ')'}, {'(', '(', ')'}});
    }
}