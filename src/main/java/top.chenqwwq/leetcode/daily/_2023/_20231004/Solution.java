package top.chenqwwq.leetcode.daily._2023._20231004;

/**
 * @author chenqwwq
 * @date 2023/10/4
 **/
public class Solution {
    private static final int INF = 0x3f3f3f3f;

    public int maxProfit(int k, int[] prices) {
        final int n = prices.length;
        // 第i天,第j次交易,0买入 1卖出
        int[][][] dp = new int[n][k][2];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2; j++) {
                dp[0][i][j] = -INF;
            }
        }
        // 第0天,第0次买入
        dp[0][0][0] = -prices[0];

        for (int i = 1; i < n; i++) {
            // 当天的首次买入
            dp[i][0][0] = Math.max(-prices[i], dp[i - 1][0][0]);
            dp[i][0][1] = Math.max(dp[i-1][0][0] + prices[i],dp[i-1][0][1]);
            for (int j = 1; j < Math.min(k, i + 1); j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] - prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] + prices[i]);
            }
        }

        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = Math.max(ans, dp[n - 1][i][1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        // WA
        new Solution().maxProfit(2,new int[]{3,2,6,5,0,3});
    }
}