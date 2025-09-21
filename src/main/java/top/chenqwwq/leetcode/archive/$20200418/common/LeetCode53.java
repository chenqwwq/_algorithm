package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 最大子序列和
 *
 * @author chen
 * @date 19-4-3
 */
public class LeetCode53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            /*
             * 一维数组DP解决
             */
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
                max = Math.max(dp[i], max);
            }
            return max;
        }
    }
}
