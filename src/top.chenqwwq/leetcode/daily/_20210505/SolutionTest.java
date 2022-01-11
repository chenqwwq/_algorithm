package top.chenqwwq.leetcode.daily._20210505;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/5/5
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void deleteAndEarn() {
        assertEquals(4, solution.deleteAndEarn(new int[]{3, 1}));
        assertEquals(6, solution.deleteAndEarn(new int[]{3, 4, 2}));
        assertEquals(9, solution.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}