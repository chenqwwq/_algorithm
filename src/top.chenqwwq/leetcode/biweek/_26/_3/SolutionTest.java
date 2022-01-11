package top.chenqwwq.leetcode.biweek._26._3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.TreeUtils;

/**
 * @author chen
 * @date 2020/5/16 下午11:18
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void goodNodes() {

        Assertions.assertEquals(4, solution.goodNodes(TreeUtils.getTreeByArray(new Integer[]{3, 1, 4, 3, null, 1, 5})));
        Assertions.assertEquals(3, solution.goodNodes(TreeUtils.getTreeByArray(new Integer[]{3, 3, null, 4, 2})));
        Assertions.assertEquals(1, solution.goodNodes(TreeUtils.getTreeByArray(new Integer[]{1})));
//        Assertions.assertEquals(4,solution.goodNodes(TreeUtils.getTreeByArray(new Integer[]{2,null,4,10,8,null,null,4})));
    }
}