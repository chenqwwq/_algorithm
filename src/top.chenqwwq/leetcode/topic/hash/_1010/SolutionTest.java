package top.chenqwwq.leetcode.topic.hash._1010;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/5/18 下午9:35
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void numPairsDivisibleBy60() {
        Assertions.assertEquals(3, solution.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        Assertions.assertEquals(3, solution.numPairsDivisibleBy60(new int[]{60, 60, 60}));
        Assertions.assertEquals(0, solution.numPairsDivisibleBy60(new int[]{439, 407, 197, 191, 291, 486, 30, 307, 11}));
        Assertions.assertEquals(1, solution.numPairsDivisibleBy60(new int[]{418, 204, 77, 278, 239, 457, 284, 263, 372, 279, 476, 416, 360, 18}));
    }
}