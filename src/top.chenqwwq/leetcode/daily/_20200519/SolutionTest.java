package top.chenqwwq.leetcode.daily._20200519;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020-05-19
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void validPalindrome() {
        Assertions.assertTrue(solution.validPalindrome("aba"));
        Assertions.assertTrue(solution.validPalindrome("abca"));
        Assertions.assertTrue(solution.validPalindrome("abccbca"));
    }
}