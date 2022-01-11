package top.chenqwwq.leetcode.lcof2._95;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chenbingxin
 * @date 2021/12/30
 **/
class SolutionTest {

    @Test
    void longestCommonSubsequence() {
        Solution solution = new Solution();
        Assertions.assertEquals(3,solution.longestCommonSubsequence("abcde","ace"));
    }
}