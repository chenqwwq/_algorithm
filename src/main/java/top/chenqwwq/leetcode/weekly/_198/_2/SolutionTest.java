package top.chenqwwq.leetcode.weekly._198._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/7/19 上午11:19
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void countSubTrees() {
        Assertions.assertArrayEquals(new int[]{1, 1, 2, 1}, solution.countSubTrees(4,
                new int[][]{
                        {0, 2}, {0, 3}, {1, 2}
                }, "aeed"));
        Assertions.assertArrayEquals(new int[]{2, 1, 1, 1, 1, 1, 1}, solution.countSubTrees(7,
                new int[][]{
                        {0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}
                }, "abaedcd"));
        Assertions.assertArrayEquals(new int[]{4, 2, 1, 1}, solution.countSubTrees(4,
                new int[][]{
                        {0, 1}, {1, 2}, {0, 3}
                }, "bbbb"));
        Assertions.assertArrayEquals(new int[]{3, 2, 1, 1, 1}, solution.countSubTrees(5,
                new int[][]{
                        {0, 1}, {0, 2}, {1, 3}, {0, 4}
                }, "aabab"));
        Assertions.assertArrayEquals(new int[]{1, 2, 1, 1, 2, 1}, solution.countSubTrees(6,
                new int[][]{
                        {0, 1}, {0, 2}, {1, 3}, {3, 4}, {4, 5}
                }, "cbabaa"));
        Assertions.assertArrayEquals(new int[]{6, 5, 4, 1, 3, 2, 1}, solution.countSubTrees(7,
                new int[][]{
                        {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}
                }, "aaabaaa"));
    }
}