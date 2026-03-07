package top.chenqwwq.leetcode.contest.weekly._491._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/3/1
 **/
public class Solution {
    public int minCost(int n) {
        int[] dp = new int[n + 1];      // dp[i] 表示 i 拆成的最小成本
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j] + (j * (i - j)));
            }
        }
        return dp[n];
    }
}