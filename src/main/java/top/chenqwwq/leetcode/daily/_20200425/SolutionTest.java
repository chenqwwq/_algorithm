package top.chenqwwq.leetcode.daily._20200425;

import jdk.nashorn.internal.ir.annotations.Ignore;
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
    @Ignore
    void permute() {
        final List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3});
    }
}