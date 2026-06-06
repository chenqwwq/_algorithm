package top.chenqwwq.leetcode.daily._2025._20251206;

/**
 * @author chenqwwq
 * @date 2025/12/6
 **/
public class Solution {
    public int countPartitions(int[] nums, int k) {
        final int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            int mn = nums[i], mx = nums[i];
            for (int j = i - 1; j > 0; j--) {
                mn = Math.min(mn, nums[j]);
                mx = Math.max(mx, nums[j]);

                if (mx - mn <= k) {
                    dp[i] = (dp[i] + dp[j]) % 1000000007;
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        new Solution().countPartitions(new int[]{9, 4, 1, 3, 7}, 4);
    }
}