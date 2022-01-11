package top.chenqwwq.leetcode.topic.graph.topological._207;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/3/7
 **/
class SolutionTest {


    Solution solution = new Solution();

    @Test
    void canFinish() {
        Assertions.assertTrue(solution.canFinish(3, new int[][]{{1, 0}, {2, 0}}));
        Assertions.assertTrue(solution.canFinish(2, new int[][]{{1, 0}}));
        Assertions.assertFalse(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        Assertions.assertFalse(solution.canFinish(20, new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}}));
    }
}