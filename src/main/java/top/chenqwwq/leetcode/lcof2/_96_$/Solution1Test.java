package top.chenqwwq.leetcode.lcof2._96_$;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chenbingxin
 * @date 2021/12/31
 **/
class Solution1Test {

    @Test
    void isInterleave() {
        Solution1 solution = new Solution1();
        Assertions.assertFalse(solution.isInterleave("aabcc","dbbca","aadbbbaccc"));
    }
}