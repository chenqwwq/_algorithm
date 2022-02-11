package top.chenqwwq.leetcode.daily._20200705;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 * <p>
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 * <p>
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 * <p>
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2020/7/5 下午10:00
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void isMatch() {
        // "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba"
        // "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"
        Assertions.assertTrue(solution.isMatch("abceb", "*a*b"));
        Assertions.assertFalse(solution.isMatch("aa", "a"));
        Assertions.assertTrue(solution.isMatch("aa", "*"));
        Assertions.assertFalse(solution.isMatch("cb", "?a"));
        Assertions.assertFalse(solution.isMatch("abced", "*a*b"));
        Assertions.assertFalse(solution.isMatch("acdcb", "a*c?b"));
        Assertions.assertTrue(solution.isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
    }
}