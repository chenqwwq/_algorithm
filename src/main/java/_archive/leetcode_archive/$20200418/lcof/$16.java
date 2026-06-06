package top.chenqwwq.leetcode.archive.$20200418.lcof;

/**
 * 面试题16. 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
 * <p>
 *
 * @author chen
 * @date 2020/3/16 上午11:13
 */
public class $16 {
    class Solution {
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }
            boolean less = false;
            if (n < 0) {
                n = -n;
                less = true;
            }
            // 递归求解
            double res = myPow(x, n >> 1);
            final double v = res * res * ((n & 1) == 1 ? x : 1);
            return less ? 1 / v : v;
        }
    }
}
