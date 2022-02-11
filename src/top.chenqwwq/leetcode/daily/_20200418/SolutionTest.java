package top.chenqwwq.leetcode.daily._20200418;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/4/18 下午2:46
 */
public class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    public void maxArea() {
        Assertions.assertEquals(49, solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        Assertions.assertEquals(0, solution.maxArea(new int[]{}));
        Assertions.assertEquals(2, solution.maxArea(new int[]{1, 2, 1}));
    }
}