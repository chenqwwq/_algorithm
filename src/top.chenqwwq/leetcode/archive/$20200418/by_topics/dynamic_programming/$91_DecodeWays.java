package top.chenqwwq.leetcode.archive.$20200418.by_topics.dynamic_programming;

/**
 * 91. 解码方法
 * <p>
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * @author bingxin.chen
 * @date 2019/12/25 09:44
 */
public class $91_DecodeWays {
    /**
     * 1. 主要还是0的边界处理
     */
    class Solution {
        private static final char ZERO = '0';

        private static final String DOUBLE_ZERO = "00";

        public int numDecodings(String s) {
            // 保证其后没有"00"出现,且首字母不为0
            if (s == null || s.length() == 0) {
                return 0;
            }
            final char[] chars = s.toCharArray();
            if (s.length() == 1) {
                return checkRange(chars[0] - '0') ? 1 : 0;
            }
            if (chars[0] == ZERO || s.contains(DOUBLE_ZERO)) {
                return 0;
            }

            // 初始条件
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 1; i < s.length(); i++) {
                int curr = (chars[i - 1] - '0') * 10 + (chars[i] - '0');

                final boolean b = checkRange(curr);
                if (b) {
                    if (chars[i] == ZERO) {
                        dp[i + 1] = dp[i - 1];
                        continue;
                    }
                    if (chars[i - 1] == ZERO) {
                        dp[i + 1] = dp[i];
                        continue;
                    }
                    dp[i + 1] = dp[i] + dp[i - 1];
                    continue;
                }

                if (chars[i] == ZERO) {
                    return 0;
                }
                dp[i + 1] = dp[i];
            }

            return dp[s.length()];
        }

        private boolean checkRange(int num) {
            return num > 0 && num <= 26;
        }
    }
}
