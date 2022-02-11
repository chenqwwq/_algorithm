package top.chenqwwq.leetcode.daily._20201112;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020-11-12
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void sortArrayByParityII() {
        Assertions.assertArrayEquals(new int[]{4,1,0,1,0,1},solution.sortArrayByParityII(new int[]{4,1,1,0,1,0}));
        Assertions.assertArrayEquals(new int[]{4,5,2,7},solution.sortArrayByParityII(new int[]{4,2,5,7}));
    }
}