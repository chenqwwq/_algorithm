package top.chenqwwq.leetcode.topic.greedy._1005;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/10/24
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void largestSumAfterKNegations() {
        Assertions.assertEquals(5, solution.largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        Assertions.assertEquals(6, solution.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        Assertions.assertEquals(13, solution.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }
}