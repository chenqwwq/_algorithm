package top.chenqwwq.leetcode.topic.dp._45;

/**
 * @author chenqwwq
 * @date 2022/5/13
 **/
public class Solution {
    final int INF = 0x3f3f3f3f;

    public int jump(int[] nums) {
        final int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = INF;
        }
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; i + j < n && j <= nums[i]; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[n - 1];
    }
}