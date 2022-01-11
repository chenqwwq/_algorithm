package top.chenqwwq.leetcode.daily._20200702;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/7/2 下午11:01
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        Assertions.assertEquals(13, solution.kthSmallest(new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        }, 8));
    }
}