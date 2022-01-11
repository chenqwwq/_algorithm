package top.chenqwwq.leetcode.weekly._214._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/11/8
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void minDeletions() {
        Assertions.assertEquals(0, solution.minDeletions("aab"));
        Assertions.assertEquals(2, solution.minDeletions("aaabbbcc"));
        Assertions.assertEquals(2, solution.minDeletions("ceabaacb"));
    }
}