package top.chenqwwq.leetcode.daily._2025._20250124;

/**
 * @author chenqwwq
 * @date 2025/1/24
 **/
public class Solution {
    private static final int INF = 0x3f3f3f3f;

    public int minimumCoins(int[] prices) {
        final int n = prices.length;
        // dp[i][0] 表示第i天买的花费
        final int[][] dp = new int[n + 1][2];
        dp[1][0] = prices[0];
        dp[1][1] = INF;
        for (int i = 2; i <= n; i++) {
            // 买水果（前一天可以买，也可以不买）
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + prices[i - 1];
            // 不买的情况下,遍历前[i-1,]
            dp[i][1] = INF;
            for (int j = i - 1; j >= (i + 1) >> 1; j--) {
                dp[i][1] = Math.min(dp[j][0], dp[i][1]);
            }
        }

        return Math.min(dp[n][0], dp[n][1]);

        // i -> i+1,i+i
        // j = 5, i = 3,4
    }


    public static void main(String[] args) {
        new Solution().minimumCoins(new int[]{1, 10, 1, 1});
    }
}