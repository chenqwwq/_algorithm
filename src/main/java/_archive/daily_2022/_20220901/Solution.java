package top.chenqwwq.leetcode.daily._2022._20220901;

/**
 * @author chenqwwq
 * @date 2022/9/1
 **/
public class Solution {
    public int[] finalPrices(int[] prices) {
        final int n = prices.length;
        int[] stack = new int[n];
        int p = -1;
        for (int i = 0; i < n; i++) {
            while (p != -1 && prices[stack[p]] >= prices[i]) {
                prices[stack[p]] = Math.max(0, prices[stack[p]] - prices[i]);
                p--;
            }
            if (p == -1 || prices[stack[p]] < prices[i]) stack[++p] = i;
        }
        return prices;
    }
}