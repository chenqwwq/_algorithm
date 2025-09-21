package top.chenqwwq.leetcode.contest.biweek._68._3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chenbingxin
 * @date 2021/12/26
 **/
class SolutionTest {

    @Test
    void canBeValid() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.canBeValid("))()))","010100"));
    }
}