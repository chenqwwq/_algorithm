package top.chenqwwq.leetcode.archive.lcof2._94;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chenbingxin
 * @date 2021/12/29
 **/
class SolutionTest {

    @Test
    void minCut() {
        Solution1 solution = new Solution1();
        Assertions.assertEquals(2,solution.minCut("abbc"));
        Assertions.assertEquals(1,solution.minCut("abbab"));
        Assertions.assertEquals(1,solution.minCut("aabbaaaa"));
        Assertions.assertEquals(0,solution.minCut("ababa"));
        Assertions.assertEquals(0,solution.minCut("abababababa"));
        Assertions.assertEquals(1,solution.minCut("abb"));
        Assertions.assertEquals(1,solution.minCut("aabb"));
    }

}