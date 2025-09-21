package top.chenqwwq.leetcode.contest.weekly._353._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2023/7/9
 **/
public class Solution {
    public int maximumJumps(int[] nums, int target) {
        final int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] == -1 || Math.abs(nums[i] - nums[j]) > target) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return dp[n - 1];
    }
}