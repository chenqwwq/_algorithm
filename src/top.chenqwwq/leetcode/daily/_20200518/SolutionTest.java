package top.chenqwwq.leetcode.daily._20200518;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/5/18 下午9:21
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxProduct() {
        Assertions.assertEquals(6, solution.maxProduct(new int[]{2, 3, -2, 4}));
        Assertions.assertEquals(0, solution.maxProduct(new int[]{-2, 0, -1}));

    }
}