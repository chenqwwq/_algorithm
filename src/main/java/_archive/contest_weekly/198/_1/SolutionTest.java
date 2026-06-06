package top.chenqwwq.leetcode.contest.weekly._198._1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/7/19 上午10:42
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void numWaterBottles() {
        Assertions.assertEquals(13, solution.numWaterBottles(9, 3));
        Assertions.assertEquals(19, solution.numWaterBottles(15, 4));
        Assertions.assertEquals(6, solution.numWaterBottles(5, 5));
        Assertions.assertEquals(2, solution.numWaterBottles(2, 3));
    }
}