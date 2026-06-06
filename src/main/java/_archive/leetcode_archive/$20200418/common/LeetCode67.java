package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 67. 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * @author bingxin.chen
 * @date 2019/8/7 12:15
 */
public class LeetCode67 {
    public static void main(String[] args) {
        new LeetCode67().new Solution().addBinary("11", "1");
    }

    class Solution {
        public String addBinary(String a, String b) {
            // 转数字直接溢出
//            return Integer.toBinaryString(Integer.valueOf(a, 2) +Integer.valueOf(b, 2));

            int la = a.length() - 1, lb = b.length() - 1;
            int carry = 0;
            StringBuffer res = new StringBuffer();
            while (la >= 0 || lb >= 0) {
                int ca = la < 0 ? 0 : a.charAt(la--) - '0';
                int cb = lb < 0 ? 0 : b.charAt(lb--) - '0';

                // 计算当前位置
                final int i = ca + cb + carry;
                res.append(i % 2);
                carry = i / 2;
            }
            if (carry > 0) {
                res.append(carry);
            }

            return res.reverse().toString();
        }
    }
}
