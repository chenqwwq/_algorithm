package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 股票买卖的最佳时机2 - 多次交易,仅能持有一支股票
 * - 想的太麻烦了 其实有收益就加上去就好 没必要保存
 *
 * @author bingxin.chen
 * @date 2019/3/25 13:09
 */
public class LeetCode122 {
    class Solution {
        //        public int maxProfit(int[] prices) {
//            if (prices == null || prices.length == 0) {
//                return 0;
//            }
//            // 一维数组DP问题,DP数组保存每日的收益
//            int[] income = new int[prices.length];
//            int maxIncome = 0;
//            // i表示prices数组的下标
//            for (int i = 1; i < prices.length; i++) {
//                if (prices[i] >= prices[i - 1]) {
//                    income[i] = prices[i] - prices[i - 1] + income[i - 1];
//                } else {
//                    income[i] = 0;
//                    maxIncome += income[i - 1];
//                }
//            }
//            return maxIncome + income[income.length - 1];
//        }
        public int maxProfit(int[] prices) {
            int income = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    income += prices[i] - prices[i - 1];
                }
            }
            return income;
        }
    }
}
