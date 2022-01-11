package top.chenqwwq.leetcode.biweek._47._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/3/6
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void checkPowersOfThree() {
        Assertions.assertTrue(solution.checkPowersOfThree(12));
        Assertions.assertTrue(solution.checkPowersOfThree(91));
        Assertions.assertFalse(solution.checkPowersOfThree(21));
        Assertions.assertTrue(solution.checkPowersOfThree(13));
        Assertions.assertTrue(solution.checkPowersOfThree(40));
        Assertions.assertFalse(solution.checkPowersOfThree(41));
    }
}