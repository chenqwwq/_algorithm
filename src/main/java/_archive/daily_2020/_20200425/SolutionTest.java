package top.chenqwwq.leetcode.daily._2020._20200425;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author chen
 * @date 2020/4/25 下午6:56
 */
class SolutionTest {
    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void permute() {
        final List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3});
    }
}