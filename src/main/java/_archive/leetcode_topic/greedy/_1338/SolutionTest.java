package top.chenqwwq.leetcode.topic.greedy._1338;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020-10-28
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void minSetSize() {
        Assertions.assertEquals(2, solution.minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
        Assertions.assertEquals(1, solution.minSetSize(new int[]{7, 7, 7, 7, 7, 7}));
        Assertions.assertEquals(1, solution.minSetSize(new int[]{1, 9}));
        Assertions.assertEquals(1, solution.minSetSize(new int[]{1000, 1000, 3, 7}));
        Assertions.assertEquals(5, solution.minSetSize(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}