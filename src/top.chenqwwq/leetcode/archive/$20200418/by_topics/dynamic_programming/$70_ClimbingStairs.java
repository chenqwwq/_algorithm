package top.chenqwwq.leetcode.archive.$20200418.by_topics.dynamic_programming;

/**
 * 70. Climbing Stairs
 * Easy
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * @author chen
 * @date 2019/9/8 下午3:31
 */
public class $70_ClimbingStairs {

    class Solution {
        public int climbStairs(int n) {
            if (n <= 1) {
                return n;
            }
            // 自底向上
            // 状态转化方程: dp[n] = dp[n-1] + dp[n-2] + 2
//            int[] dp = new int[n];
//            dp[0] = 1;
//            dp[1] = 2;
//            for (int i = 2;i < n;i++){
//                dp[i] = dp[i-1] + dp[i-2];
//            }
//            return dp[n-1];

            // 自顶向下
            // 记忆化递归
            int[] dp = new int[n];
            return dpHandler(n - 1, dp);
        }

        private int dpHandler(int n, int[] dp) {
            if (n <= 1) {
                return n + 1;
            }
            if (dp[n] > 0) {
                return dp[n];
            }
            dp[n] = dpHandler(n - 1, dp) + dpHandler(n - 2, dp);
            return dp[n];
        }
    }
}
