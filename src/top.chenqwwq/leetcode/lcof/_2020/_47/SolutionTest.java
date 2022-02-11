package top.chenqwwq.leetcode.lcof._2020._47;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/6/24 上午11:49
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxValue() {
        Assertions.assertEquals(12, solution.maxValue(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }
}