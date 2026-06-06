package top.chenqwwq.leetcode.daily._2023._20231006;

/**
 * @author chenqwwq
 * @date 2023/10/6
 **/
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        final int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i] - fee);
        }
        return Math.max(0,dp[n-1][1]);
    }
}