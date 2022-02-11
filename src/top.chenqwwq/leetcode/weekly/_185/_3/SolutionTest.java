package top.chenqwwq.leetcode.weekly._185._3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/4/19 上午11:13
 */
class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void minNumberOfFrogs() {
        Assertions.assertEquals(1, solution.minNumberOfFrogs("croakcroak"));
        Assertions.assertEquals(2, solution.minNumberOfFrogs("crcoakroak"));
        Assertions.assertEquals(-1, solution.minNumberOfFrogs("croakcrook"));
        Assertions.assertEquals(-1, solution.minNumberOfFrogs("croakcroa"));
    }
}