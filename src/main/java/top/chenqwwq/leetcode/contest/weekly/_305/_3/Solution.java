package top.chenqwwq.leetcode.contest.weekly._305._3;

/**
 * @author chenqwwq
 * @date 2022/8/7
 **/
public class Solution {
    public boolean validPartition(int[] nums) {
        final int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        dp[1] = false;
        dp[2] = nums[0] == nums[1];
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 3] && ((nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3]) || (nums[i - 1] == nums[i - 2] + 1) && nums[i - 2] == nums[i - 3] + 1);
            dp[i] = dp[i] || (dp[i - 2] && nums[i - 1] == nums[i - 2]);
        }
        return dp[n];
    }

}