package top.chenqwwq.leetcode.daily._2021._20211230;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1,2,3,6,2,3,4,7,8]
 * 3
 * [1,2,3,4,5]
 * 4
 * @author chenbingxin
 * @date 2021/12/30
 **/
class SolutionTest {

    @Test
    void isNStraightHand() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.isNStraightHand(new int[]{0,1},2));
        Assertions.assertTrue(solution.isNStraightHand(new int[]{1,1,2,2,3,3},2));
        Assertions.assertTrue(solution.isNStraightHand(new int[]{1,5},1));
        Assertions.assertTrue(solution.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8},3));
        Assertions.assertFalse(solution.isNStraightHand(new int[]{1,2,3,4,5},4));
        Assertions.assertTrue(solution.isNStraightHand(new int[]{1,2,3,4,5},1));
        Assertions.assertTrue(solution.isNStraightHand(new int[]{1,2,3,4,5},5));
    }
}