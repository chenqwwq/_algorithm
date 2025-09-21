package top.chenqwwq.leetcode.contest.biweek._147._4;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2025/1/4
 **/
public class Solution {
    public long maxSubarraySum(int[] nums) {
        return -1;
    }
    public long dp(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        long[] dp = new long[n];
        dp[0] = nums[0];
        long maxSum = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

}