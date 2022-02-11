package top.chenqwwq.leetcode.daily._20200710;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * @author chen
 * @date 2020-07-10
 **/
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // 纵轴分别表示 持有和不持有和冷却不持有3种状态
        // 横轴表示每天的利润
        int[][] dp = new int[3][prices.length];
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // 想要持有，那么前一天只能是冷却不持有或者持有状态
            dp[0][i] = Math.max(dp[0][i - 1], dp[2][i - 1] - prices[i]);

            // 想要卖出只能持有
            dp[1][i] = dp[0][i - 1] + prices[i];

            // 冷却期，上次是卖出或者冷却
            dp[2][i] = Math.max(dp[1][i - 1], dp[2][i - 1]);
        }

        return Math.max(dp[1][prices.length - 1], dp[2][prices.length - 1]);


    }
}