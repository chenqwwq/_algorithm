package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 买卖股票的最佳时机 - 只能进行一次交易
 *
 * @author bingxin.chen
 * @date 2019/3/25 11:08
 */
public class LeetCode121 {
    class Solution {
        public int maxProfit(int[] prices) {
            // 找到数组的最小值和最大值
            int minPrice = Integer.MAX_VALUE, maxIncome = 0;
            for (int i : prices) {
                if (minPrice > i) {
                    minPrice = i;
                } else {
                    maxIncome = Math.max(i - minPrice, maxIncome);
                }
            }
            return maxIncome;
        }
    }
}
