package top.chenqwwq.leetcode.daily._20200624;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/6/24 上午11:36
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void threeSumClosest() {
        Assertions.assertEquals(2, solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}