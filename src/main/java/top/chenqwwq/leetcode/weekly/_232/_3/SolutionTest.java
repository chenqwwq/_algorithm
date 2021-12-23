package top.chenqwwq.leetcode.weekly._232._3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/3/14
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxAverageRatio() {
        Assertions.assertEquals(0.78333, solution.maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2));
    }
}