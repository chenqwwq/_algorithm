package top.chenqwwq.leetcode.archive.$20200418.lcof;

/**
 * 面试题10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 * 注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/
 *
 * @author chen
 * @date 2020/3/6 下午3:17
 */
public class $10_1 {
    class Solution {
        public int fib(int n) {
            if (n < 2) {
                return n;
            }
            int a = 0, b = 1;
            int c = -1;
            for (int i = 2; i <= n; i++) {
                c = (int) ((a + b) % (1e9 + 7));
                a = b;
                b = c;
            }

            return b;
        }
    }
}
