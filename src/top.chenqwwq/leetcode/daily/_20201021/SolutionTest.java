package top.chenqwwq.leetcode.daily._20201021;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1：
 * <p>
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 * <p>
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * 示例 3：
 * <p>
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 *
 * @author chen
 * @date 2020-10-21
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void isLongPressedName() {
        Assertions.assertFalse(solution.isLongPressedName("pyplrz", "ppyypllr"));
        Assertions.assertFalse(solution.isLongPressedName("dfuyalc", "fuuyallc"));
        Assertions.assertTrue(solution.isLongPressedName("vtkgn", "vttkgnn"));
        Assertions.assertTrue(solution.isLongPressedName("alex", "aaleex"));
        Assertions.assertFalse(solution.isLongPressedName("saeed", "ssaaedd"));
        Assertions.assertTrue(solution.isLongPressedName("leelee", "lleeelee"));
        Assertions.assertTrue(solution.isLongPressedName("laiden", "laiden"));
    }
}