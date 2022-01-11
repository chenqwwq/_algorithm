package top.chenqwwq.leetcode.daily._20210428;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/4/28
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void judgeSquareSum() {
        assertTrue(solution.judgeSquareSum(1));
        assertTrue(solution.judgeSquareSum(2));
        assertFalse(solution.judgeSquareSum(3));
        assertTrue(solution.judgeSquareSum(4));
        assertTrue(solution.judgeSquareSum(5));
    }

}