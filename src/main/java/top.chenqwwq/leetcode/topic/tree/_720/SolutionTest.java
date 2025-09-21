package top.chenqwwq.leetcode.topic.tree._720;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1:
 * <p>
 * 输入:
 * words = ["w","wo","wor","worl", "world"]
 * 输出: "world"
 * 解释:
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 * 示例 2:
 * <p>
 * 输入:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出: "apple"
 * 解释:
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2020/7/12 下午3:29
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void longestWord() {
        Assertions.assertEquals("world", solution.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        Assertions.assertEquals("apple", solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
}