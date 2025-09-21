package top.chenqwwq.leetcode.archive.$20200418.by_topics.bit;

/**
 * 693. 交替位二进制数
 * <p>
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 * 示例 2:
 * <p>
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 * 示例 3:
 * <p>
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 * 示例 4:
 * <p>
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 *
 * @author bingxin.chen
 * @date 2019/12/9 18:09
 */
public class $693_BinaryNumberWithAlternatingBits {
    class Solution {
        private static final int i = 0x00000011;

        public boolean hasAlternatingBits(int n) {

            while (n > 0) {
                // 取末尾的两位
                final int j = n & Solution.i;
                if (j != 1) {
                    return false;
                }
                n = n >> 2;
            }
            return true;
        }
    }
}





















