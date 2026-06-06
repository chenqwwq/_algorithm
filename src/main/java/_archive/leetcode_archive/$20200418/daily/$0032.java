package top.chenqwwq.leetcode.archive.$20200418.daily;

import java.util.Arrays;

/**
 * 1111. 有效括号的嵌套深度
 * 有效括号字符串 仅由 "(" 和 ")" 构成，并符合下述几个条件之一：
 * <p>
 * 空字符串
 * 连接，可以记作 AB（A 与 B 连接），其中 A 和 B 都是有效括号字符串
 * 嵌套，可以记作 (A)，其中 A 是有效括号字符串
 * 类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度 depth(S)：
 * <p>
 * s 为空时，depth("") = 0
 * s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是有效括号字符串
 * s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串
 * 例如：""，"()()"，和 "()(()())" 都是有效括号字符串，嵌套深度分别为 0，1，2，而 ")(" 和 "(()" 都不是有效括号字符串。
 * <p>
 * 给你一个有效括号字符串 seq，将其分成两个不相交的子序列 A 和 B，且 A 和 B 满足有效括号字符串的定义（注意：A.length + B.length = seq.length）。
 * <p>
 * 现在，你需要从中选出 任意 一组有效括号字符串 A 和 B，使 max(depth(A), depth(B)) 的可能取值最小。
 * <p>
 * 返回长度为 seq.length 答案数组 answer ，选择 A 还是 B 的编码规则是：如果 seq[i] 是 A 的一部分，那么 answer[i] = 0。否则，answer[i] = 1。即便有多个满足要求的答案存在，你也只需返回 一个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 * 示例 2：
 * <p>
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 * <p>
 * 提示：
 * <p>
 * 1 <= text.size <= 10000
 *
 * @author chen
 * @date 2020/4/1 上午10:55
 */
public class $0032 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $0032().new Solution().maxDepthAfterSplit("()(())()")));
    }

    class Solution {

        private static final char LEFT = '(';

        public int[] maxDepthAfterSplit(String seq) {
            int curr = 1, num = 1;
            int[] res = new int[seq.length()];
            final char[] chars = seq.toCharArray();
            res[0] = 0;

            for (; curr < chars.length; curr++) {
                if (chars[curr] == LEFT) {
                    res[curr] = num++;
                } else {
                    res[curr] = --num;
                }
            }

            return res;

        }
    }
}
