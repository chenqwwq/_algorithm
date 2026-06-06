package top.chenqwwq.leetcode.contest.weekly._504._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/5/31
 **/
public class Solution {

    static final int INF = 0x3f3f3f3f;

    public int maximumSaleItems(int[][] items, int budget) {
        // 最终要求返回的最大购物数量
        final int n = items.length;

        // 记录每个商品可以免费获得的商品数量
        // cnt[i] 表示第 i 个物品可以免费获得多少个其他物品
        final int[] cnt = new int[n];
        int mn = INF;
        for (int i = 0; i < n; i++) {
            mn = Math.min(mn, items[i][1]);
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (items[j][0] % items[i][0] == 0) {
                    cnt[i]++;
                }
            }
        }

        int[] dp = new int[budget + 1];
        Arrays.fill(dp, -INF);       // dp[i] 表示花费 i 可以获得的商品总数
        dp[0] = 0;
        for (int i = 0; i < n; i++) {       // 枚举每一个物品
            for (int j = budget; j >= items[i][1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - items[i][1]] + cnt[i] + 1);
            }
        }


        int ans = 0;
        for (int i = 0; i <= budget; i++) {
            ans = Math.max(ans, dp[i] + (budget - i) / mn);
        }
        return ans;
    }
}