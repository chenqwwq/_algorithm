package top.chenqwwq.leetcode.contest.weekly._415._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2024/9/21
 **/
public class Solution {
    public long maxScore(int[] a, int[] b) {
        final int n = b.length;
        final long[][] dp = new long[4][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = (long)a[0] * b[j];
        }
        long ans = Long.MIN_VALUE;
        for (int i = 1; i < 4; i++) {
            Arrays.fill(dp[i], Long.MIN_VALUE);
            long max = Long.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (j >= i) dp[i][j] = Math.max(dp[i][j], max + (long) a[i] * b[j]);
                max = Math.max(max, dp[i - 1][j]);
                if(i == 3) ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}