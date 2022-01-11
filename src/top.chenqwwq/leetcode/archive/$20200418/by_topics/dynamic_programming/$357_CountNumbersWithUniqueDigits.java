package top.chenqwwq.leetcode.archive.$20200418.by_topics.dynamic_programming;

/**
 * 357. 计算各个位数不同的数字个数
 * <p>
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 * <p>
 * 示例:
 * <p>
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 *
 * @author bingxin.chen
 * @date 2019/12/26 15:08
 */
public class $357_CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        System.out.println(new $357_CountNumbersWithUniqueDigits().new Solution().countNumbersWithUniqueDigits(4));
    }

    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return 10;
            }
            int res = 10, pre = 9;
            for (int i = 2; i <= n; i++) {
                res += (pre *= (11 - i));
            }
            return res;
        }
    }
}
