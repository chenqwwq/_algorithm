package top.chenqwwq.leetcode.contest.weekly._411._2;

/**
 * @author chenqwwq
 * @date 2024/8/20
 **/
public class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        final int n = energyDrinkA.length;

        // 定义状态 0 选A,1 选B,2 不选
        final long[][] dp = new long[3][n];
        dp[0][0] = energyDrinkA[0];
        dp[1][0] = energyDrinkB[0];

        // 递推
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[2][i - 1]) + energyDrinkA[i];
            dp[1][i] = Math.max(dp[1][i - 1], dp[2][i - 1]) + energyDrinkB[i];
            dp[2][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
        }

        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }
}