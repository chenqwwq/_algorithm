package top.chenqwwq.leetcode.biweek._47._1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/3/6
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void nearestValidPoint() {
        Assertions.assertEquals(2, solution.nearestValidPoint(3, 4, new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}}));
        Assertions.assertEquals(0, solution.nearestValidPoint(3, 4, new int[][]{{3, 4}}));
        Assertions.assertEquals(-1, solution.nearestValidPoint(3, 4, new int[][]{{2, 3}}));
    }
}