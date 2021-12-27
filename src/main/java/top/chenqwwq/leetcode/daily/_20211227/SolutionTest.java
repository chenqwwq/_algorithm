package top.chenqwwq.leetcode.daily._20211227;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chenbingxin
 * @date 2021/12/27
 **/
class SolutionTest {

    @Test
    void numFriendRequests() {
        Solution solution = new Solution();
        Assertions.assertEquals(2,solution.numFriendRequests(new int[]{118,14,7,63,103}));
        Assertions.assertEquals(3,solution.numFriendRequests(new int[]{20,30,100,110,120}));
        Assertions.assertEquals(2,solution.numFriendRequests(new int[]{16,17,18}));
        Assertions.assertEquals(2,solution.numFriendRequests(new int[]{16,16}));
    }
}