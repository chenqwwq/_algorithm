package top.chenqwwq.leetcode.daily._2026._202605010;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/5/10
 **/
public class Solution {
    public int maximumJumps(int[] nums, int target) {
        final int n = nums.length;
        int[] dp = new int[n];      // dp[i] 代表以 i 结尾的最大跳跃次数
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != -1 && Math.abs(nums[j] - nums[i]) <= target) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}