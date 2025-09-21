package top.chenqwwq.leetcode.topic.greedy._1221;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/10/24
 **/
class SolutionTest {
    Solution solution = new Solution();

    @Test
    void balancedStringSplit() {
        Assertions.assertEquals(4, solution.balancedStringSplit("RLRRLLRLRL"));
        Assertions.assertEquals(3, solution.balancedStringSplit("RLLLLRRRLR"));
        Assertions.assertEquals(1, solution.balancedStringSplit("LLLLRRRR"));
    }
}