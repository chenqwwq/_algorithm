package top.chenqwwq.leetcode.contest.weekly._299._2;

/**
 * @author chenqwwq
 * @date 2022/6/26
 **/
public class Solution {
    int mod = (int) 1e9 + 7;

    public int countHousePlacements(int n) {
        long[][] dp = new long[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            dp[i][1] = dp[i - 1][0];
        }
        long total = (dp[n - 1][0] + dp[n - 1][1]) % mod;
        return (int) ((total * total) % mod);
    }
}