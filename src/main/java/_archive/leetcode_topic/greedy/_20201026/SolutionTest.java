package top.chenqwwq.leetcode.topic.greedy._20201026;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020-10-26
 **/
class SolutionTest {


    Solution solution = new Solution();

    @Test
    void findMinArrowShots() {
        Assertions.assertEquals(2, solution.findMinArrowShots(new int[][]
                {
                        {10, 16}, {2, 8}, {1, 6}, {7, 12}
                }));
        Assertions.assertEquals(3, solution.findMinArrowShots(new int[][]
                {
                        {1, 2}, {3, 4}, {5, 6}, {6, 8}
                }));
        Assertions.assertEquals(4, solution.findMinArrowShots(new int[][]
                {
                        {1, 2}, {3, 4}, {5, 6}, {7, 8}
                }));
        Assertions.assertEquals(2, solution.findMinArrowShots(new int[][]
                {
                        {1, 2}, {2, 3}, {3, 4}, {4, 5}
                }));
        Assertions.assertEquals(1, solution.findMinArrowShots(new int[][]
                {
                        {1, 2}
                }));
    }
}