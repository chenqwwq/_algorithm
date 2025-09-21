package top.chenqwwq.leetcode.archive.$20200418.by_topics.dynamic_programming;

/**
 * 338. Counting Bits
 * Medium
 * <p>
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 * <p>
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 *
 * @author chen
 * @date 2019/11/16 下午7:05
 */
public class $338_CountingBits {
    class Solution {
        public int[] countBits(int num) {
            // 给出一个n,计算从0~n的每个数字二进制位中1的数目
            // dp解题
            // 奇数的话等于上一个数+1
            // 偶数的话等于dp[2n] = dp[n]
            // 类似题解里面的最低有效位

            // 确定dp的状态转化方程
            // dp[n]表示n二进制位中1的数目
            int[] dp = new int[num + 1];

            dp[0] = 0;

            for (int i = 2; i < num + 1; i++) {
                dp[i] = (i & 1) == 1 ? dp[i - 1] + 1 : dp[i >> 1];
            }

            return dp;
        }
    }
}
