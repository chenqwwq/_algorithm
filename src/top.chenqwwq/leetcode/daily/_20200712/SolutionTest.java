package top.chenqwwq.leetcode.daily._20200712;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/7/12 下午4:09
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void calculateMinimumHP() {
        Assertions.assertEquals(7, solution.calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        }));

        Assertions.assertEquals(1, solution.calculateMinimumHP(new int[][]{
                {100},
        }));
    }
}