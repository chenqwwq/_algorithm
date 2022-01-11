package top.chenqwwq.leetcode.weekly._188._2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author chen
 * @date 2020/5/10 下午5:31
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void countTriplets() {
        assertEquals(4, solution.countTriplets(new int[]{2, 3, 1, 6, 7}));
        assertEquals(10, solution.countTriplets(new int[]{1, 1, 1, 1, 1}));
        assertEquals(0, solution.countTriplets(new int[]{2, 3}));
        assertEquals(3, solution.countTriplets(new int[]{1, 3, 5, 7, 9}));
        assertEquals(8, solution.countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
    }
}