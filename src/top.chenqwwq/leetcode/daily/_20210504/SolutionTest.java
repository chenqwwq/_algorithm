package top.chenqwwq.leetcode.daily._20210504;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/5/4
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void minCost() {
        assertEquals(9, solution.minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3));
        assertEquals(11, solution.minCost(new int[]{0, 2, 1, 2, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3));
        assertEquals(5, solution.minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{{1, 10}, {10, 1}, {1, 10}, {10, 1}, {1, 10}}, 5, 2, 5));
        assertEquals(-1, solution.minCost(new int[]{3, 1, 2, 3}, new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 4, 3, 3));
        assertEquals(12, solution.minCost(new int[]{0, 0, 0, 1}, new int[][]{{1, 5}, {4, 1}, {1, 3}, {4, 4}}, 4, 2, 4));
    }
}