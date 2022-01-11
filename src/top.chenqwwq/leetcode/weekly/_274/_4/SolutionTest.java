package top.chenqwwq.leetcode.weekly._274._4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chenbingxin
 * @date 2022/1/2
 **/
class SolutionTest {

    @Test
    void maximumInvitations() {
        Solution solution = new Solution();
        Assertions.assertEquals(6, solution.maximumInvitations(new int[]{1,0,0,2,1,4,7,8,9,6,7,10,8}));
        Assertions.assertEquals(3, solution.maximumInvitations(new int[]{2, 2, 1, 2}));
    }
}