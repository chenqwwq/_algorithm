package top.chenqwwq.leetcode.daily._2023._20230601;

import java.util.Arrays;

/**
 * @author 沽酒
 * @since 2023/06/02
 */
public class Solution {
    public int maximumTastiness(int[] price, int k) {
        final int n = price.length;
        Arrays.sort(price);
        int l = 0, r = price[n - 1] - price[0];
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(price, mid, 0, k - 1)) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    public boolean check(int[] prices, int gap, int l, int k) {
        if (k <= 0) return true;
        int i = l;
        while (++i < prices.length) {
            if (prices[i] - prices[l] >= gap) {
                return check(prices, gap, i, k - 1);
            }
        }
        return false;
    }
}