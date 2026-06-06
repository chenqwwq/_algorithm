package top.chenqwwq.leetcode.contest.weekly._353._3;

/**
 * @author chenqwwq
 * @date 2023/7/9
 **/
public class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        int ans = 1;
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i][1] = 1;
            if (nums1[i] >= nums1[i - 1]) dp[i][0] = Math.max(dp[i][0], dp[i - 1][0] + 1);
            if (nums1[i] >= nums2[i - 1]) dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + 1);
            if (nums2[i] >= nums1[i - 1]) dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + 1);
            if (nums2[i] >= nums2[i - 1]) dp[i][1] = Math.max(dp[i][1], dp[i - 1][1] + 1);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }
}
