package top.chenqwwq.leetcode.lcof._2020._54;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.TreeUtils;

/**
 * @author chen
 * @date 2020/4/18 下午4:43
 */
class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void kthLargest() {
        Assertions.assertEquals(0, solution.kthLargest(TreeUtils.getTreeByArray(new Integer[]{}), 0));
        Assertions.assertEquals(4, solution.kthLargest(TreeUtils.getTreeByArray(new Integer[]{3, 1, 4, null, 2}), 1));
        Assertions.assertEquals(4, solution.kthLargest(TreeUtils.getTreeByArray(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 3));
    }
}