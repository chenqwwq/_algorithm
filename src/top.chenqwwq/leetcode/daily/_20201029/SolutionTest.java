package top.chenqwwq.leetcode.daily._20201029;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.TreeUtils;

/**
 * @author chen
 * @date 2020-10-29
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void sumNumbers() {
        Assertions.assertEquals(1, solution.sumNumbers(TreeUtils.getTreeByArray(new Integer[]{0, 1})));
        Assertions.assertEquals(25, solution.sumNumbers(TreeUtils.getTreeByArray(new Integer[]{1, 2, 3})));
        Assertions.assertEquals(1026, solution.sumNumbers(TreeUtils.getTreeByArray(new Integer[]{4, 9, 0, 5, 1})));
    }
}