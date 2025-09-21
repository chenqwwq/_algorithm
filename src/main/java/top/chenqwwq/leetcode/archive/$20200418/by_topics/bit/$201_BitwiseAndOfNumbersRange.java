package top.chenqwwq.leetcode.archive.$20200418.by_topics.bit;

/**
 * 201. 数字范围按位与
 * <p>
 * 题目描述
 * 评论 (62)
 * 题解(15)New
 * 提交记录
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: [0,1]
 * 输出: 0
 *
 * @author bingxin.chen
 * @date 2019/11/29 10:49
 */
public class $201_BitwiseAndOfNumbersRange {

    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            // 暴力会时间超限
//            int q = m;
//            // ++m会存在溢出的情况
//            while (++m <= n && q != 0) {
//                q &= m;
//            }
//            return q;

            // 按位&,所以只要出现一个0就会导致结果为0
            int count = 0;
            while (m != n) {
                // m和n分别进位
                m >>= 1;
                n >>= 1;
                count++;
            }
            return n << count;
        }
    }
}
