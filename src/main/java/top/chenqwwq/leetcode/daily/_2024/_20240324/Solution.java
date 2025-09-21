package top.chenqwwq.leetcode.daily._2024._20240324;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2024/3/24
 **/
public class Solution {

    private static final int INF = 0x3f3f3f3f;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        Arrays.sort(coins);
        final int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) break;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == INF ? -1 : dp[amount];
    }
}