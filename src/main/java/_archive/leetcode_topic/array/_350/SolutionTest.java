package top.chenqwwq.leetcode.topic.array._350;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.ArrayUtils;

/**
 * @author chen
 * @date 2020/4/25 下午4:48
 */
class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void intersect() {
        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{2, 2}, solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{4, 9}, solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}