package top.chenqwwq.leetcode.archive.$20200418.by_topics.math;

/**
 * 7. 整数反转
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author chen
 * @date 2019/11/24 下午2:15
 */
public class $7_ReverseInteger {

    class Solution {
        public int reverse(int x) {
            if (x > -9 && x < 9) {
                return x;
            }

            // 判断正负
            boolean isPositive = x > 0;
            x = isPositive ? x : -x;

            // 需要考虑移除问题,移除就返回0,直接使用long类型存放int
            long tmp = 0;

            while (x > 0) {
                // 从最低位开始
                // 取余数,余数就是
                int curr = x % 10;

                if ((tmp = tmp * 10 + curr) > Integer.MAX_VALUE) {
                    return 0;
                }

                x /= 10;
            }

            return isPositive ? (int) tmp : (int) -tmp;
        }
    }
}
