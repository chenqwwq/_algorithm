package top.chenqwwq.leetcode.biweek._28._1;

/**
 * 5420. 商品折扣后的最终价格 显示英文描述
 * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * <p>
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
 * <p>
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 500
 * 1 <= prices[i] <= 10^3
 *
 * @author chen
 * @date 2020/6/13 下午10:32
 */
public class Solution {
    public int[] finalPrices(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return prices;
        }

        int[] res = new int[prices.length];

        outer:
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    res[i] = prices[i] - prices[j];
                    continue outer;
                }
            }
            res[i] = prices[i];
        }

        return res;
    }
}