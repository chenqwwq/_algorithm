package top.chenqwwq.leetcode.daily._20200703;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.TreeUtils;

/**
 * @author chen
 * @date 2020-07-03
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void sortedArrayToBST() {
        Assertions.assertTrue(TreeUtils.isBinarySearchTree(solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9})));
    }
}