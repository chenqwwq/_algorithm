package top.chenqwwq.leetcode.archive.lcof2._37;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chenbingxin
 * @date 2022/1/1
 **/
class SolutionTest {

    @Test
    void asteroidCollision() {
        Solution solution = new Solution();
        Assertions.assertEquals(new int[]{-2,-1,-2},solution.asteroidCollision(new int[]{-2,-1,1,-2}));
        Assertions.assertEquals(new int[]{10},solution.asteroidCollision(new int[]{10,2,-5}));
        Assertions.assertEquals(new int[]{-2,-2,-2},solution.asteroidCollision(new int[]{-2,-2,1,-2}));
        Assertions.assertEquals(new int[]{},solution.asteroidCollision(new int[]{8,-8}));
    }
}