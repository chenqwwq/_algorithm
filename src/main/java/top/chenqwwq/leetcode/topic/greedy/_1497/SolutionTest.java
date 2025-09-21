package top.chenqwwq.leetcode.topic.greedy._1497;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020-10-26
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void canArrange() {
        Assertions.assertTrue(solution.canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5));
        Assertions.assertTrue(solution.canArrange(new int[]{1, 2, 3, 4, 5, 6}, 7));
        Assertions.assertFalse(solution.canArrange(new int[]{1, 2, 3, 4, 5, 6}, 10));
        Assertions.assertTrue(solution.canArrange(new int[]{-10, 10}, 2));
        Assertions.assertTrue(solution.canArrange(new int[]{-1, 1, -2, 2, -3, 3, -4, 4}, 3));
        Assertions.assertTrue(solution.canArrange(new int[]{-4, -7, 5, 2, 9, 1, 10, 4, -8, -3}, 3));

    }
}