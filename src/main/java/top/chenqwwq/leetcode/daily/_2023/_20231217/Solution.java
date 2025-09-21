package top.chenqwwq.leetcode.daily._2023._20231217;

/**
 * @author chenqwwq
 * @date 2023/12/17
 **/
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        final int n = cost.length;
        final int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        return dp[n];
    }
}
