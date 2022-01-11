package top.chenqwwq.leetcode.daily._20200426;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1,2,3,4,5,12,6,7,8,4,9,1,6,7,8,9,10]
 * 5
 * [1,2,3,1,1]
 * 4
 * [1,2,3,4,5,6,7,8,9,10]
 * 5
 * [3,2,2,4,1,4]
 * 3
 *
 * @author chen
 * @date 2021-04-26
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void shipWithinDays() {
//        Assertions.assertEquals(solution.shipWithinDays(new int[]{1, 2, 3, 4, 5, 12, 6, 7, 8, 4, 9, 1, 6, 7, 8, 9, 10}, 5), 25);
//        Assertions.assertEquals(solution.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5), 15);
//        Assertions.assertEquals(solution.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3), 6);
        Assertions.assertEquals(solution.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4), 3);
    }
}