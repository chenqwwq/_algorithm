package top.chenqwwq.leetcode.daily._2023._20231002;

/**
 * @author chenqwwq
 * @date 2023/10/3
 **/
public class Solution {
    public int maxProfit(int[] prices) {
        final int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}