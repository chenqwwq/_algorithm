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
        Assertions.assertTrue(solution.wordBreak("leetcode", Arrays.asList("leet", "code")));
        Assertions.assertTrue(solution.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        Assertions.assertFalse(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}