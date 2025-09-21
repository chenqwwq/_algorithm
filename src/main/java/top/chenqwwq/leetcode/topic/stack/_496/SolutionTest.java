package top.chenqwwq.leetcode.topic.stack._496;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020-10-19
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void nextGreaterElement() {
        Assertions.assertArrayEquals(new int[]{-1, 3, -1}, solution.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
        Assertions.assertArrayEquals(new int[]{3, -1}, solution.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4}));
    }
}