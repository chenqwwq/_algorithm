package top.chenqwwq.leetcode.contest.weekly._494._4;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/3/22
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().countGoodSubarrays(new int[]{1, 1, 3});
    }

    public long countGoodSubarrays(int[] nums) {
        final int n = nums.length;
        Arrays.sort(nums);

        long ans = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) ans++;
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (((nums[i] ^ nums[j]) & nums[j]) == 0) {
                    ans += dp[j];
                    dp[i] += dp[j];
                }
            }
        }
        return ans;
    }

}