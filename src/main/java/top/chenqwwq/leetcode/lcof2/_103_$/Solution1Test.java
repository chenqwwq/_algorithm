package top.chenqwwq.leetcode.lcof2._103_$;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chenbingxin
 * @date 2022/1/3
 **/
class Solution1Test {

    @Test
    void coinChange() {
        Solution1 solution = new Solution1();
        Assertions.assertEquals(3,solution.coinChange(new int[]{1,2,5},11));
    }
}