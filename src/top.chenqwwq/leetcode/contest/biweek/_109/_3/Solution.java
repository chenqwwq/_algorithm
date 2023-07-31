package top.chenqwwq.leetcode.contest.biweek._109._3;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2023/7/22
 **/
public class Solution {
    public long maxScore(int[] nums, int x) {
        final int n = nums.length;
        long[] dp = new long[2];
        Arrays.fill(dp, -0x3f3f3f3f);
        dp[nums[0] & 1] = nums[0];
        for (int i = 1; i < n; i++) {
            final int k = nums[i] & 1;
            dp[k] = Math.max(dp[k], dp[k ^ 1] - x) + nums[i];
        }
        return Math.max(dp[0], dp[1]);
    }
}