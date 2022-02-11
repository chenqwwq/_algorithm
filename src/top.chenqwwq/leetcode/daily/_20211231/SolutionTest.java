package top.chenqwwq.leetcode.daily._20211231;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chenbingxin
 * @date 2021/12/31
 **/
class SolutionTest {

    @Test
    void checkPerfectNumber() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.checkPerfectNumber(1));
        Assertions.assertFalse(solution.checkPerfectNumber(2));
        Assertions.assertTrue(solution.checkPerfectNumber(28));
        Assertions.assertFalse(solution.checkPerfectNumber(36));
    }
}