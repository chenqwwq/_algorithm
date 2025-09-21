package top.chenqwwq.leetcode.topic.greedy._1578;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020-10-26
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void minCost() {
        Assertions.assertEquals(3, solution.minCost("abaac", new int[]{1, 2, 3, 4, 5}));
        Assertions.assertEquals(0, solution.minCost("abc", new int[]{3, 4, 5}));
        Assertions.assertEquals(2, solution.minCost("aabaa", new int[]{1, 3, 4, 5, 1}));
    }
}