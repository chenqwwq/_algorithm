package top.chenqwwq.leetcode.archive.lcof2._103_$;

import java.util.Arrays;

/**
 * @author chenbingxin
 * @date 2022/1/3
 **/
public class Solution1 {
    private int INF = 0x3F3F3F3F;

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        final int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == INF ? -1 : dp[amount];
    }
}