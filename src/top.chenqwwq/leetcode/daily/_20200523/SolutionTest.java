package top.chenqwwq.leetcode.daily._20200523;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/5/24 上午9:25
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void minWindow() {
        Assertions.assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
        Assertions.assertEquals("a", solution.minWindow("a", "a"));
        Assertions.assertEquals("", solution.minWindow("a", "aa"));
        Assertions.assertEquals("", solution.minWindow("a", "b"));
        Assertions.assertEquals("aa", solution.minWindow("aa", "aa"));
    }
}