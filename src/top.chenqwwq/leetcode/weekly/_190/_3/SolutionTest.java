package top.chenqwwq.leetcode.weekly._190._3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.TreeUtils;

/**
 * @author chen
 * @date 2020/5/24 上午10:58
 */
class SolutionTest {

    @Test
    void pseudoPalindromicPaths() {
        Assertions.assertEquals(2, new Solution().pseudoPalindromicPaths(TreeUtils.getTreeByArray(new Integer[]{2, 3, 1, 3, 1, null, 1})));
        Assertions.assertEquals(1, new Solution().pseudoPalindromicPaths(TreeUtils.getTreeByArray(new Integer[]{2, 1, 1, 1, 3, null, null, null, null, null, 1})));
        Assertions.assertEquals(1, new Solution().pseudoPalindromicPaths(TreeUtils.getTreeByArray(new Integer[]{9})));
    }
}