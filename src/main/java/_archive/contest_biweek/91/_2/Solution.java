package top.chenqwwq.leetcode.contest.biweek._91._2;

/**
 * @author chenqwwq
 * @date 2022/11/14
 **/
public class Solution {
    int mod = (int) 1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high + 1];
        dp[0] = 1L;
        long ans = 0;
        for (int i = 1; i <= high; i++) {
            if (i - zero >= 0) dp[i] = (dp[i] + dp[i - zero]) % mod;
            if (i - one >= 0) dp[i] = (dp[i] + dp[i - one]) % mod;
            if (i >= low) ans = (ans + dp[i]) % mod;
        }
        return (int)ans;
    }
}