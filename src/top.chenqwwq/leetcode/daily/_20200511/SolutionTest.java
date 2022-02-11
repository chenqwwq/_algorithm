package top.chenqwwq.leetcode.daily._20200511;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.NumberUtils;

/**
 * @author chen
 * @date 2020/5/11 下午9:00
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void myPow() {
        Assertions.assertEquals(1024.00000, NumberUtils.getScale(solution.myPow(2.00000d, 10), 5));
        Assertions.assertEquals(9.26100, NumberUtils.getScale(solution.myPow(2.10000d, 3), 5));
        Assertions.assertEquals(0.25000, NumberUtils.getScale(solution.myPow(2.00000d, -2), 5));
        Assertions.assertEquals(0.00000, NumberUtils.getScale(solution.myPow(2.00000d, -2147483648), 5));
    }
}