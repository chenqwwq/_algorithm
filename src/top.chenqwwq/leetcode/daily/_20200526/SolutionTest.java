package top.chenqwwq.leetcode.daily._20200526;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020-05-26
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void findDuplicate() {
        Assertions.assertEquals(2, solution.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        Assertions.assertEquals(3, solution.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}