package top.chenqwwq.leetcode.daily._20201030;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/10/30
 **/
class SolutionTest {

    Solution solution = new Solution();
    int[][] grid = {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}};

    @Test
    void islandPerimeter() {
        Assertions.assertEquals(16, solution.islandPerimeter(grid));
    }
}