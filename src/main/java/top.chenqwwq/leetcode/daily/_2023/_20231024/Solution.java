package top.chenqwwq.leetcode.daily._2023._20231024;

/**
 * @author chenqwwq
 * @date 2023/10/24
 **/
public class Solution {
    private static final int mod = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int q = 0; q <= target; q++) {
                for (int j = 1; j <= k; j++) {
                    if(q - j < 0) continue;;
                    dp[i][q] = (dp[i][q] + dp[i - 1][q-j]) % mod;
                }
            }
        }
        return dp[n][target];
    }
}