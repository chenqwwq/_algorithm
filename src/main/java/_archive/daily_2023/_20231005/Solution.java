package top.chenqwwq.leetcode.daily._2023._20231005;

/**
 * @author chenqwwq
 * @date 2023/10/5
 **/
public class Solution {
    public int maxProfit(int[] prices) {
        final int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 0. 不持有,且不处于冷却期
            dp[i][0] = Math.max(dp[i - 1][3], dp[i - 1][0]);
            // 1. 持有
            dp[i][1] =  Math.max(dp[i][0] - prices[i],dp[i-1][1]);
            // 2. 卖出
            dp[i][2] = dp[i - 1][1] + prices[i];
            // 3. 处于冷却期
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(0, Math.max(dp[n - 1][0], Math.max(dp[n - 1][2], dp[n - 1][3])));
    }
}