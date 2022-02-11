package top.chenqwwq.leetcode.daily._20201026;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020-10-26
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void smallerNumbersThanCurrent() {
        Assertions.assertArrayEquals(new int[]{4, 0, 1, 1, 3}, solution.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3}));
        Assertions.assertArrayEquals(new int[]{2, 1, 0, 3}, solution.smallerNumbersThanCurrent(new int[]{6, 5, 4, 8}));
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0}, solution.smallerNumbersThanCurrent(new int[]{7, 7, 7, 7}));
    }
}