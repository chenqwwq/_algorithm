package top.chenqwwq.leetcode.daily._20210506;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author chen
 * @date 2021-05-06
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void decode() {
        assertArrayEquals(new int[]{1, 0, 2, 1}, solution.decode(new int[]{1, 2, 3}, 1));
        assertArrayEquals(new int[]{4, 2, 0, 7, 4}, solution.decode(new int[]{6, 2, 7, 3}, 4));
    }
}