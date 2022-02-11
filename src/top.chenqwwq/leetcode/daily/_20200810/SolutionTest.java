package top.chenqwwq.leetcode.daily._20200810;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * 示例 1 :
 * <p>
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * <p>
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * <p>
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 * <p>
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 *
 * @author chen
 * @date 2020/8/10 下午11:10
 */
class SolutionTest {
    Solution solution = new Solution();

    @Test
    void countBinarySubstrings() {
        Assertions.assertEquals(6, solution.countBinarySubstrings("00110011"));
        Assertions.assertEquals(4, solution.countBinarySubstrings("10101"));
    }
}