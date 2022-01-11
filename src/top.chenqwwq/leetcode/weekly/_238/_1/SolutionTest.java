package top.chenqwwq.leetcode.weekly._238._1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-04-25
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void sumBase() {
        Assertions.assertEquals(solution.sumBase(34, 6), 9);
        Assertions.assertEquals(solution.sumBase(10, 10), 1);
    }
}