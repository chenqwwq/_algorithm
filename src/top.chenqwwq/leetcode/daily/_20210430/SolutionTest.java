package top.chenqwwq.leetcode.daily._20210430;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-04-30
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void singleNumber() {
        Assertions.assertEquals(solution.singleNumber(new int[]{2, 2, 3, 2}), 3);
        Assertions.assertEquals(solution.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}), 99);
    }
}