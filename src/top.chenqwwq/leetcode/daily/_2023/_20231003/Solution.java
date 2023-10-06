package top.chenqwwq.leetcode.daily._2023._20231003;

/**
 * @author chenqwwq
 * @date 2023/10/3
 **/
public class Solution {

    private static final int INF = (int) 0x3f3f3f3f;

    public int maxProfit(int[] prices) {
        // 定义状态
        // 0. 无操作
        // 1. 第一次持有
        // 2. 第二次持有
        // 3. 第一次卖出
        // 4. 第二次卖出

        final int n = prices.length;
        int[][] dp = new int[n][5];
        dp[0][1] = -prices[0];
        dp[0][2] = dp[0][3] = dp[0][4] = -INF;

        for (int i = 1; i < n; i++) {
            // 当前是第一次买入
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i],dp[i-1][1]);

            // 当前是第二次买入
            dp[i][2] = Math.max(dp[i - 1][3] - prices[i], dp[i - 1][2]);

            // 当前是第一次卖出
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][1] + prices[i]);

            // 当前是第二次卖出
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][2] + prices[i]);
        }

        return Math.max(0,Math.max(dp[n-1][3],dp[n-1][4]));
    }
}