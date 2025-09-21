package top.chenqwwq.leetcode.daily._2023._20230711;

/**
 * @author 沽酒
 * @since 2023/07/11
 */
public class Solution {
    public long maxAlternatingSum(int[] nums) {
        final int n = nums.length;
        // dp[i][0] 表示有偶数个数字时 0~i 的最大值
        // dp[i][1] 表示有奇数个数字时 0~i 的最大值
        long[][] dp = new long[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}