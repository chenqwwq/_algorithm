package top.chenqwwq.leetcode.daily._20200710;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * @author chen
 * @date 2020-07-10
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxProfit() {
        Assertions.assertEquals(3, solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
        Assertions.assertEquals(1, solution.maxProfit(new int[]{1, 2}));
    }
}