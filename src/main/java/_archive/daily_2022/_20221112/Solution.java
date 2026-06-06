package top.chenqwwq.leetcode.daily._2022._20221112;

/**
 * @author chenqwwq
 * @date 2022/11/14
 **/
public class Solution {
    int mod = (int) 1e9 + 7;

    public int numTilings(int n) {
        long[][] dp = new long[n][4];
        dp[0][3] = 1L;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            dp[i][2] = (dp[i - 1][2] + dp[i - 1][0]) % mod;
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % mod;
        }
        return (int)dp[n-1][3];
    }
}