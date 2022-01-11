package top.chenqwwq.leetcode.daily._20201105;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author chen
 * @date 2020-11-05
 **/
class SolutionTest {
    Solution solution = new Solution();

    @Test
    void ladderLength() {

        Assertions.assertEquals(5, solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        Assertions.assertEquals(0, solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));

    }
}