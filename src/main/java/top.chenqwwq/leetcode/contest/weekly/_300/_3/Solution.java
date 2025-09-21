package top.chenqwwq.leetcode.contest.weekly._300._3;

/**
 * @author chenqwwq
 * @date 2022/7/3
 **/
public class Solution {
    int mod = (int) 1e9 + 7;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        // cur 维护 i-delay 到 i-forget 之间的和
        long total = 1, canSpread = 0;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int add = i - delay, del = i - forget;
            if (del > 0) {
                canSpread = (canSpread - dp[del] + mod) % mod;
                total = (total - dp[del] + mod) % mod;
            }
            if (add > 0) {
                canSpread = (canSpread + dp[add]) % mod;
            }
            dp[i] = canSpread;
            total = (total + canSpread) % mod;
        }
        return (int) total;
    }
}