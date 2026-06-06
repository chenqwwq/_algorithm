package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * @author chen
 * @description 求数组中满足要求的最大和, 相邻元素只能之用一个
 * 1. 初始计划采用动态规划
 * @email chenbxxx@gmail.com
 * @date 19-3-3
 */
public class LeetCode198 {
    public static void main(String[] args) {
        System.out.println(new LeetCode198().new Solution().rob(new int[]{1, 2, 3, 1}));
    }

    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int[] dp = new int[nums.length + 1];
            dp[1] = nums[0];
            dp[2] = nums[1];
            for (int i = 3; i < dp.length; i++) {
                dp[i] = Math.max(nums[i - 1] + dp[i - 2], nums[i - 1] + dp[i - 3]);
            }
            return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
        }
    }
}
