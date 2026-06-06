package top.chenqwwq.leetcode.daily._2023._20230808;

import java.util.Arrays;

import static java.lang.Math.*;

/**
 * @author chenqwwq
 * @date 2023/8/8
 **/
public class Solution {
    public int maxAbsoluteSum(int[] nums) {
        final int n = nums.length;
        long[] dp = new long[n];
        dp[0] = max(nums[0], 0);
        long ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = max(0, max(dp[i - 1] + nums[i], nums[i]));
            ans = max(dp[i], ans);
        }

        Arrays.fill(dp, 0);
        dp[0] = min(0, nums[0]);
        ans = max(abs(dp[0]), ans);
        for (int i = 1; i < n; i++) {
            dp[i] = min(0, min(dp[i-1]+nums[i],nums[i]));
            ans = max(abs(dp[i]),ans);
        }
        return (int) ans;
    }
}