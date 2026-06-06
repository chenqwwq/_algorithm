package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * <p>
 * 示例1:
 * <p>
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *  
 * <p>
 * 示例2:
 * <p>
 * 输入: 3
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 19-7-18 下午11:10
 */
public class LeetCode633 {
    class Solution {
        public boolean judgeSquareSum(int c) {
            int i = 0, sqrt = (int) Math.sqrt(c) + 1;

            while (i <= sqrt) {
                int sum = i * i + sqrt * sqrt;
                if (sum == c) {
                    return true;
                } else if (sum < c) {
                    i++;
                } else {
                    sqrt--;
                }
            }
            return false;
        }
    }
}
