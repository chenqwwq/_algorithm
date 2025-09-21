package top.chenqwwq.leetcode.daily._2024._20240325;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2024/3/25
 **/
public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        Arrays.sort(coins);
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}