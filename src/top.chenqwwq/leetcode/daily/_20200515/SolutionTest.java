package top.chenqwwq.leetcode.daily._20200515;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020-05-15
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void subarraySum() {
        Assertions.assertEquals(2, solution.subarraySum(new int[]{1, 1, 1}, 2));
    }
}