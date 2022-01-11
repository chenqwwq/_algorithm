package top.chenqwwq.leetcode.biweek._26._1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/5/16 下午10:47
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxPower() {
        Assertions.assertEquals(2, solution.maxPower("leetcode"));
        Assertions.assertEquals(5, solution.maxPower("abbcccddddeeeeedcba"));
        Assertions.assertEquals(5, solution.maxPower("triplepillooooow"));
        Assertions.assertEquals(11, solution.maxPower("hooraaaaaaaaaaay"));
        Assertions.assertEquals(1, solution.maxPower("tourist"));
    }
}