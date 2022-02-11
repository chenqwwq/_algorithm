package top.chenqwwq.leetcode.daily._20210405;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-04-09
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void merge() {
        final int[] ints = {4, 5, 6, 0, 0, 0};
        solution.merge(ints, 3, new int[]{1, 2, 3}, 3);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, ints);

        final int[] i1 = {0};
        solution.merge(i1, 0, new int[]{1}, 1);
        Assertions.assertArrayEquals(new int[]{1}, i1);

        final int[] i2 = {1};
        solution.merge(i2, 1, new int[]{}, 0);
        Assertions.assertArrayEquals(new int[]{1}, i2);

        final int[] i3 = {1, 3, 5, 7, 9, 0, 0, 0};
        solution.merge(i3, 5, new int[]{2, 4, 5}, 3);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 5, 7, 9}, i3);

    }
}