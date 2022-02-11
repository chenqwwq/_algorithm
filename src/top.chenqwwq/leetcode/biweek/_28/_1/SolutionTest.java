package top.chenqwwq.leetcode.biweek._28._1;

import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.ArrayUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author chen
 * @date 2020/6/13 下午10:36
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void finalPrices() {
        assertTrue(ArrayUtils.arrEqual(new int[]{4, 2, 4, 2, 3}, solution.finalPrices(new int[]{8, 4, 6, 2, 3})));
        assertTrue(ArrayUtils.arrEqual(new int[]{1, 2, 3, 4, 5}, solution.finalPrices(new int[]{1, 2, 3, 4, 5})));
        assertTrue(ArrayUtils.arrEqual(new int[]{9, 0, 1, 6}, solution.finalPrices(new int[]{10, 1, 1, 6})));
    }
}