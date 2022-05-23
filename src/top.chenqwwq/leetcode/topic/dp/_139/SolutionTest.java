package top.chenqwwq.leetcode.topic.dp._139;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author chen
 * @date 2020-11-02
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void wordBreak() {
        Assertions.assertTrue(solution.wordBreak("bb", Arrays.asList("a", "b","bbb","bbbb")));
    }
}