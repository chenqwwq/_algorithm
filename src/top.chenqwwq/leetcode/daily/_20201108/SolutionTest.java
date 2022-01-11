package top.chenqwwq.leetcode.daily._20201108;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2020/11/8
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxProfit() {
        Assertions.assertEquals(7,solution.maxProfit(new int[]{7,1,5,3,6,4}));
        Assertions.assertEquals(4,solution.maxProfit(new int[]{1,2,3,4,5}));
        Assertions.assertEquals(0,solution.maxProfit(new int[]{7,6,4,3,1}));
    }
}