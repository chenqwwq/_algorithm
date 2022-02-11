package top.chenqwwq.leetcode.daily._20210429;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author chen
 * @date 2021-04-29
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void canCross() {

        assertTrue(solution.canCross(new int[]{0, 1, 3, 6, 10, 15, 16, 21}));
        assertTrue(solution.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        assertFalse(solution.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }
}