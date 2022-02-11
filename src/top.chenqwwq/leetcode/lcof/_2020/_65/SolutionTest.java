package top.chenqwwq.leetcode.lcof._2020._65;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020-06-30
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void add() {
        Assertions.assertEquals(7, solution.add(3, 4));
        Assertions.assertEquals(11, solution.add(8, 3));
        Assertions.assertEquals(17, solution.add(15, 2));
        Assertions.assertEquals(37, solution.add(23, 14));
    }
}