package top.chenqwwq.leetcode.weekly._239._2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/5/2
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void splitString() {
        assertTrue(solution.splitString("4771447713"));
        assertFalse(solution.splitString("001"));
        assertTrue(solution.splitString("99999999999999999998"));
        assertFalse(solution.splitString("1234"));
        assertTrue(solution.splitString("050043"));
        assertFalse(solution.splitString("9080701"));
        assertTrue(solution.splitString("10009998"));
        assertTrue(solution.splitString("10"));
        assertFalse(solution.splitString("9999999999999999999"));
    }
}