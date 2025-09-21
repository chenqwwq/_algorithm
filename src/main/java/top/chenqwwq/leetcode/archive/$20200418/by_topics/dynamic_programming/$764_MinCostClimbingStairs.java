package top.chenqwwq.leetcode.archive.$20200418.by_topics.dynamic_programming;

/**
 * 746. Min Cost Climbing Stairs
 * Easy
 * <p>
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * <p>
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 *
 * @author chen
 * @date 2019/9/8 下午2:42
 */
public class $764_MinCostClimbingStairs {
    class Solution {
        /**
         * dp练习
         */
        public int minCostClimbingStairs(int[] cost) {
            if (cost == null || cost.length == 0) {
                return 0;
            }
            // 自底向上
            // 定义最优子结构，确定状态转化方程
            // dp[n]表示在n级台阶上最少花费的体力
            // dp[n] = Math.min(dp[n-1],dp[n-2])+cost[n]
//            int[] dp = new int[cost.length+1];
//            dp[0] = 0;
//            dp[1] = cost[0];
//            for (int i = 1;i < cost.length;i++){
//               dp[i+1] = Math.min(dp[i],dp[i-1])+cost[i];
//            }
//            return Math.min(dp[cost.length],dp[cost.length-1]);

            // 自顶向下
            // 一般采用递归的形式,但如何实现计划化才是重点

            int[] res = new int[cost.length];
            return Math.min(dpHandler(cost, cost.length - 1, res), dpHandler(cost, cost.length - 2, res));

        }

        /**
         * 记忆化递归一直超时,无奈
         */
        private int dpHandler(int[] cost, int n, int[] res) {
            if (n <= 1) {
                return cost[n];
            }

            if (res[n] > 0) {
                return res[n];
            }

            res[n] = Math.min(dpHandler(cost, n - 1, res), dpHandler(cost, n - 2, res)) + cost[n];

            // 递归求解
            // 若无记忆化，每边的递归都会分裂重新计算 所以最后时间复杂度可能达到O(n^2)
//            return Math.min(dpHandler(cost,n-1,res),dpHandler(cost,n-2,res))+cost[n];

            return res[n];
        }
    }
}
