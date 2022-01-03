package top.chenqwwq.leetcode.lcof2._99;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chenbingxin
 * @date 2022/1/2
 **/
class SolutionTest {

    @Test
    void minPathSum() {
        Solution solution = new Solution();
        Assertions.assertEquals(7, solution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}