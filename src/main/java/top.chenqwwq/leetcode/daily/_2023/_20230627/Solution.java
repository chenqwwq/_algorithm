package top.chenqwwq.leetcode.daily._2023._20230627;

/**
 * @author 沽酒
 * @since 2023/06/27
 */

class Solution {
    public int maximumSum(int[] arr) {
        final int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][0] = arr[0];
        dp[0][1] = 0;
        int ans = dp[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], 0) + arr[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }
}