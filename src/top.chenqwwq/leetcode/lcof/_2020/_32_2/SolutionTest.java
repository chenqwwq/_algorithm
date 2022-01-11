package top.chenqwwq.leetcode.lcof._2020._32_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.ListUtils;
import top.chenqwwq.leetcode.utils.TreeUtils;

/**
 * @author chen
 * @date 2020/4/18 下午5:33
 */
class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void levelOrder() {
        Assertions.assertEquals(ListUtils.getList(new Integer[][]{}), solution.levelOrder(null));
        Assertions.assertEquals(ListUtils.getList(new Integer[][]{{3}, {9, 20}, {15, 7}}), solution.levelOrder(TreeUtils.getTreeByArray(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}