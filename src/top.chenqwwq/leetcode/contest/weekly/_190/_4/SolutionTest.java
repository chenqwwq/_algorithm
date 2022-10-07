package top.chenqwwq.leetcode.contest.weekly._190._4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/5/24 上午11:25
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxDotProduct() {
        Assertions.assertEquals(18, solution.maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}));
        Assertions.assertEquals(21, solution.maxDotProduct(new int[]{3, -2}, new int[]{2, -6, 7}));
        Assertions.assertEquals(-1, solution.maxDotProduct(new int[]{-1, -1}, new int[]{1, 1}));
    }
}