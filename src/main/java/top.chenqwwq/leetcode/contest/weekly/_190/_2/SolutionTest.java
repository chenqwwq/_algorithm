package top.chenqwwq.leetcode.contest.weekly._190._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/5/24 上午10:43
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxVowels() {
        Assertions.assertEquals(3, solution.maxVowels("abciiidef", 3));
        Assertions.assertEquals(2, solution.maxVowels("aeiou", 2));
        Assertions.assertEquals(2, solution.maxVowels("leetcode", 3));
        Assertions.assertEquals(0, solution.maxVowels("rhythms", 4));
        Assertions.assertEquals(1, solution.maxVowels("novowels", 1));
    }
}