package top.chenqwwq.leetcode.daily._2024._20241101;

/**
 * @author chenqwwq
 * @date 2024/11/2
 **/
public class Solution {
    public long maxEnergyBoost(int[] as, int[] bs) {
        final int n = as.length;
        // 0 -> a,1 -> b,2 -> 不选
        final int[][] dp = new int[n][3];
        dp[0][0] = as[0];
        dp[0][1] = bs[0];
        for (int i = 1; i < n - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]) + as[i];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]) + as[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][0]);
        }
        return Math.max(Math.max(dp[n-1][0],dp[n-1][1]),dp[n-1][2]);
    }
}