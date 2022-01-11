package top.chenqwwq.leetcode.weekly._189._1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/5/17 上午11:08
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void busyStudent() {
        Assertions.assertEquals(1, solution.busyStudent(new int[]{4}, new int[]{4}, 4));
        Assertions.assertEquals(0, solution.busyStudent(new int[]{4}, new int[]{4}, 5));
        Assertions.assertEquals(0, solution.busyStudent(new int[]{1, 1, 1, 1}, new int[]{1, 3, 2, 4}, 7));
        Assertions.assertEquals(5, solution.busyStudent(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10}, 5));
    }
}