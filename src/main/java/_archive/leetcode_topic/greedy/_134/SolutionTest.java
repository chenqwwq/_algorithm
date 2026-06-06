package top.chenqwwq.leetcode.topic.greedy._134;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020-10-27
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void canCompleteCircuit() {
        Assertions.assertEquals(3, solution.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        Assertions.assertEquals(-1, solution.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}