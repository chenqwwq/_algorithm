package top.chenqwwq.leetcode.daily._20200708;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.ArrayUtils;

/**
 * @author chen
 * @date 2020/7/8 下午10:32
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void divingBoard() {
        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{3, 4, 5, 6}, solution.divingBoard(1, 2, 3)));
    }
}