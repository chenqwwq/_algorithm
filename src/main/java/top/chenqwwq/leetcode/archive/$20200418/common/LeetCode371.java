package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 371. 两整数之和
 * <p>
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: a = -2, b = 3
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author bingxin.chen
 * @date 2019/7/15 19:15
 */
public class LeetCode371 {
    class Solution {
        public int getSum(int a, int b) {
            int res, a1, b1;
            do {
                a1 = (a ^ b);
                b1 = ((a & b) << 1);
                res = a1 | b1;
                a = a1;
                b = b1;
            } while (b1 != 0);
            return res;
        }
    }
}
