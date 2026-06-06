package top.chenqwwq.leetcode.contest.weekly._185._1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/4/19 上午10:56
 */
class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void reformat() {
        Assertions.assertEquals("a0b1c2", solution.reformat("a0b1c2"));
        Assertions.assertEquals("c2o0v1i9d", solution.reformat("covid2019"));
        Assertions.assertEquals("", solution.reformat("1229857369"));
        Assertions.assertEquals("", solution.reformat("src/chenqwwq/leetcode"));
        Assertions.assertEquals("3a1b2", solution.reformat("ab123"));
    }
}