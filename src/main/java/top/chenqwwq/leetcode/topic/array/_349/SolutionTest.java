package top.chenqwwq.leetcode.topic.array._349;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.ArrayUtils;

/**
 * @author chen
 * @date 2020/4/25 下午3:36
 */
class SolutionTest {

    private Solution solution;


    @BeforeEach
    void setUp() {
        this.solution = new Solution();
    }

    @Test
    void intersection() {
        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{2}, solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{9, 4}, solution.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}