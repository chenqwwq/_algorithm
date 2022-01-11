package top.chenqwwq.leetcode.lcof2._35;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.ListUtils;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chenbingxin
 * @date 2021/12/31
 **/
class SolutionTest {

    @Test
    void findMinDifference() {
        Solution solution = new Solution();
        Assertions.assertEquals(719,solution.findMinDifference(Arrays.asList("12:12","00:13")));
        Assertions.assertEquals(1,solution.findMinDifference(Arrays.asList("23:59","00:00")));
    }
}