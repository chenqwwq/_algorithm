package top.chenqwwq.leetcode.biweek._26._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author chen
 * @date 2020/5/16 下午10:52
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void simplifiedFractions() {
        Assertions.assertEquals(solution.simplifiedFractions(2), Arrays.asList("1/2"));
        Assertions.assertEquals(solution.simplifiedFractions(3), Arrays.asList("1/2", "1/3", "2/3"));
        Assertions.assertEquals(solution.simplifiedFractions(6), Arrays.asList("1/2", "1/3", "1/4", "1/5", "1/6", "2/3", "2/5", "3/4", "3/5", "4/5", "5/6"));
        Assertions.assertEquals(solution.simplifiedFractions(1), new ArrayList<>());
    }
}