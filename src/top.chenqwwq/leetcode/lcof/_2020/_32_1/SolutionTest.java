package top.chenqwwq.leetcode.lcof._2020._32_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.ArrayUtils;
import top.chenqwwq.leetcode.utils.TreeUtils;

/**
 * @author chen
 * @date 2020/6/25 上午9:16
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void levelOrder() {
        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{3, 9, 20, 15, 7}, solution.levelOrder(TreeUtils.getTreeByArray(new Integer[]{3, 9, 20, null, null, 15, 7}))));
        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{1, 2, 3, 4, 5}, solution.levelOrder(TreeUtils.getTreeByArray(new Integer[]{1, 2, 3, 4, 5}))));
        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{3, 9, 20, 15, 7}, solution.levelOrder(TreeUtils.getTreeByArray(new Integer[]{3, 9, 20, null, null, 15, 7}))));
    }
}