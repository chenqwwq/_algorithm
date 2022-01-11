package top.chenqwwq.leetcode.daily._20200613;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/6/13 下午1:59
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void climbStairs() {
        Assertions.assertEquals(solution.climbStairs(3), 3);
        Assertions.assertEquals(solution.climbStairs(2), 2);
        Assertions.assertEquals(solution.climbStairs(5), 8);
    }
}