package top.chenqwwq.leetcode.weekly._197._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1：
 * <p>
 * 输入：s = "0110111"
 * 输出：9
 * 解释：共有 9 个子字符串仅由 '1' 组成
 * "1" -> 5 次
 * "11" -> 3 次
 * "111" -> 1 次
 * 示例 2：
 * <p>
 * 输入：s = "101"
 * 输出：2
 * 解释：子字符串 "1" 在 s 中共出现 2 次
 * 示例 3：
 * <p>
 * 输入：s = "111111"
 * 输出：21
 * 解释：每个子字符串都仅由 '1' 组成
 * 示例 4：
 * <p>
 * 输入：s = "000"
 * 输出：0
 *
 * @author chen
 * @date 2020/7/12 上午10:46
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void numSub() {
        Assertions.assertEquals(9, solution.numSub("0110111"));
        Assertions.assertEquals(2, solution.numSub("101"));
        Assertions.assertEquals(21, solution.numSub("111111"));
        Assertions.assertEquals(0, solution.numSub("000"));
    }
}