package top.chenqwwq.leetcode.daily._20201110;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020-11-10
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void nextPermutation() {
        final int[] p1 = {1, 2, 3};
        solution.nextPermutation(p1);
        Assertions.assertArrayEquals(new int[]{1, 3, 2}, p1);

        final int[] p2 = {3, 2, 1};
        solution.nextPermutation(p2);
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, p2);

        final int[] p3 = {1, 1, 5};
        solution.nextPermutation(p3);
        Assertions.assertArrayEquals(new int[]{1, 5, 1}, p3);

        final int[] p4 = {9,8,7,2,6,5,4,3,2,1};
        solution.nextPermutation(p4);
        Assertions.assertArrayEquals(new int[]{9,8,7,3,1,2,2,4,5,6}, p4);
    }
}