package top.chenqwwq.leetcode.lcof2._17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chenbingxin
 * @date 2021/12/29
 **/
class SolutionTest {

    @Test
    void minWindow() {
        Solution solution = new Solution();
        Assertions.assertEquals("BANC",solution.minWindow("ADOBECODEBANC","ABC"));
    }
}