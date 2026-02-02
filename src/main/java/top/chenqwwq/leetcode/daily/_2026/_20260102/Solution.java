package top.chenqwwq.leetcode.daily._2026._20260102;

/**
 * @author chenqwwq
 * @date 2026/1/6
 **/
public class Solution {
    public int numOfWays(int n) {
        final int mod = 1000000007;
        final long[][][] dp = new long[n][3][3];

        // 第一行第一列三种颜色都只有一种
        for (int i = 0; i < 3; i++) dp[0][0][i] = 1;

        // 推导
        // dp[i][j][0] = dp[i-1][j][1] + dp[i-1][j][2] + dp[i][j-1][1] + dp[i][j-1][2]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0 && j == 0) continue;
                for (int k = 0; k < 3; k++) {   // 当前涂什么颜色
                    long t = 0;
                    for (int l = 0; l < 3; l++) {       // 周边颜色
                        if (l == k) continue;
                        t = (t + (i > 0 ? dp[i - 1][j][l] : 0) + (j > 0 ? dp[i][j - 1][l] : 0)) % mod;
                    }
                    dp[i][j][k] = t;
                }
            }
        }
        return (int) ((dp[n - 1][2][0] + dp[n - 1][2][1] + dp[n - 1][2][2]) % mod);
    }
}