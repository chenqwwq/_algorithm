package top.chenqwwq.leetcode.archive.$20200418.lcof;

/**
 * 面试题10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 提示：
 * <p>
 * 0 <= n <= 100
 * 注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/
 *
 * @author chen
 * @date 2020/3/6 下午3:18
 */
public class $10_2 {
    class Solution {
        public int numWays(int n) {

            if (n <= 2) {
                return n == 0 ? 1 : n;
            }

            // dp公式 ==> dp[i] = dp[i-1] + dp[i-2]
            // 1 1 2 3 5

            // 起始数据
            int a = 1, b = 2;
            int c = -1;
            for (int i = 3; i <= n; i++) {
                c = (int) ((a + b) % (1e9 + 7));
                a = b;
                b = c;
            }

            return b;

        }
    }
}
