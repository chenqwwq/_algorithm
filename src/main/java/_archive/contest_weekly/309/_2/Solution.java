package top.chenqwwq.leetcode.contest.weekly._309._2;

/**
 * @author chenqwwq
 * @date 2022/9/4
 **/
public class Solution {
    int mod = (int) 1e9 + 7;

    public int numberOfWays(int startPos, int endPos, int k) {
        if (Math.abs(startPos - endPos) > k) {
            return 0;
        }
        int N = 2001;
        long[][] dp = new long[k + 1][N];
        dp[0][startPos - endPos + 1000] = 1;
        for (int i = 1; i <= k; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][N - 1] = dp[i - 1][N - 2];
            for (int j = 1; j < N - 1; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }
        }

        return (int)dp[k][1000];
    }

}