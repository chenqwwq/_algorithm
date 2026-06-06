package top.chenqwwq.leetcode.archive.$20200418.by_topics.dynamic_programming;

/**
 * 121. Best Time to Buy and Sell Stock
 * Easy
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * @author chen
 * @date 2019/9/7 下午7:02
 */
public class $121_BestTimeToBuyAndSellStockI {
    class Solution {
        public int maxProfit(int[] prices) {
            int res = 0;
            if (prices == null || prices.length == 0) {
                return res;
            }
            // 刚开始有点想差了
            // 记录到当前为止的最低进价
            // 每次计算最低进价和当前价格的差值就好
            int minPrice = Integer.MAX_VALUE;
            for (int price : prices) {
                minPrice = Math.min(minPrice, price);
                res = Math.max(res, price - minPrice);
            }

            return res;
        }
    }
}
