package top.chenqwwq.leetcode.archive.$20200418.daily;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * @author chen
 * @date 2020/3/8 上午8:37
 */
public class $0008 {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            // dp[i]表示i元时的最小硬币数目
            // dp[i]就等于Math.min(for(q:coins.length) ==> dp[i - q] + 1)
            dp[0] = 0;

            // 对应的硬币面值大小的都为1
            for (int i : coins) {
                if (i <= amount) {
                    dp[i] = 1;
                }
            }

            for (int i = 1; i <= amount; i++) {
                int temp = Integer.MAX_VALUE - 1;
                for (int c : coins) {
                    if (i - c < 0) {
                        continue;
                    }
                    temp = Math.min(temp, dp[i - c] + 1);
                }
                dp[i] = temp;
            }

            return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
        }
    }
}
