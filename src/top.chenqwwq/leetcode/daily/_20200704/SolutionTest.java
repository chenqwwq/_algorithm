package top.chenqwwq.leetcode.daily._20200704;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2020/7/4 下午11:36
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void longestValidParentheses() {
        Assertions.assertEquals(6, solution.longestValidParentheses("()(())"));
        Assertions.assertEquals(4, solution.longestValidParentheses("()()"));
        Assertions.assertEquals(2, solution.longestValidParentheses("()"));
        Assertions.assertEquals(2, solution.longestValidParentheses("(()"));
        Assertions.assertEquals(4, solution.longestValidParentheses(")()())"));
        Assertions.assertEquals(0, solution.longestValidParentheses("(((("));
        Assertions.assertEquals(0, solution.longestValidParentheses(")"));
    }
}