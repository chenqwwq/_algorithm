package top.chenqwwq.leetcode.archive.$20200418.by_topics.dynamic_programming;

/**
 * 122. Best Time to Buy and Sell Stock II
 * Easy
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * @author chen
 * @date 2019/9/7 下午8:01
 */
public class $122_BestTimeToBuyAndSellStockII {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }

            // 不算常规的DP解法
            // 遍历一次,累加序列中每次的递增,忽略递减几号
            // 时间复杂度 = O(n)
//            int res = 0;
//            for (int i = 1;i < prices.length;i++){
//                int i1 = prices[i] - prices[i - 1];
//                res += Math.max(i1, 0);
//            }
//            return res;


            // dp解决,相对于上面的方法可能时间复杂度更大
            // 主要练习下状态转化方程的推导
            // 首先每天的状态可以区分为持有股票和不持有股票
            // dp负责记录下每天各种状态的盈利
            int[][] dp = new int[2][prices.length];

            dp[0][0] = 0;
            dp[1][0] = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                // 未持有股票的状态下的盈利 = MAX[上次持有股票+当前价格,上次未持有股票 ]
                dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i]);
                // 持有股票的状态下的盈利 = MAX[上次未持有股票-当前价格,上次就持有股票]
                dp[1][i] = Math.max(dp[0][i - 1] - prices[i], dp[1][i - 1]);
            }

            return dp[0][prices.length - 1];


        }
    }
}
